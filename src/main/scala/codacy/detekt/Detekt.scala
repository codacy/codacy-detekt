package codacy.detekt

import java.nio.file.{Path, Paths}
import java.util

import codacy.docker.api
import codacy.docker.api._
import codacy.dockerApi.utils.FileHelper
import io.gitlab.arturbosch.detekt.api._
import io.gitlab.arturbosch.detekt.core._
import org.jetbrains.kotlin.psi.KtFile
import org.yaml.snakeyaml.Yaml
import play.api.libs.json.{JsString, Json}

import scala.collection.JavaConversions._
import scala.io.Source
import scala.util.Try

object Detekt extends Tool {
  val configFiles = Set("default-detekt-config.yml", "detekt.yml")
  private lazy val rules: Map[String, Seq[Rule]] = getRules

  override def apply(source: api.Source.Directory, configuration: Option[List[Pattern.Definition]], filesOpt: Option[Set[api.Source.File]])
                    (implicit specification: Tool.Specification): Try[List[Result]] = {
    Try {
      val sourcePath = Paths.get(source.path)
      val parallel = true
      val yamlConfig = getYamlConfig(configuration, sourcePath)

      val findings = getResults(sourcePath, filesOpt, yamlConfig, parallel)

      findings.map { finding =>
        Result.Issue(
          api.Source.File(finding.getFile),
          Result.Message(finding.compact()),
          Pattern.Id(finding.getId),
          codacy.docker.api.Source.Line(finding.getLocation.getSource.getLine)
        )
      }
    }
  }

  private def mapRules: Map[String, String] = (for {
    (category, rules) <- rules
    r <- rules
  } yield r.getId -> category) (collection.breakOut)


  private def category(p: Pattern.Definition): String = mapRules(p.patternId.value)


  private def getYamlConfig(config: Option[List[Pattern.Definition]], source: Path): YamlConfig = {
    config.fold {
      defaultConfig(source)
    } {
      mapConfig
    }
  }

  private def defaultConfig(source: Path): YamlConfig = {
    val map = FileHelper.findConfigurationFile(configFiles, source)
      .fold(new util.LinkedHashMap[String, Any]()) {
        configFile =>
          new Yaml()
            .load(Source.fromFile(configFile.toFile).getLines().mkString("\n"))
            .asInstanceOf[util.LinkedHashMap[String, Any]]
      }
    new YamlConfig(map)
  }

  private def mapConfig(config: List[Pattern.Definition]): YamlConfig = {
    val configByCategory = config.groupBy(category)

    val configMapGen: Map[String, Any] = (for {
      category <- rules.keys.toList
      patternsRaw = configByCategory.getOrElse(category, List.empty[Pattern.Definition])
    } yield {
      val patterns: Map[String, Any] = patternsRaw.map { p =>
        val parameters: Map[String, Any] = p.parameters.getOrElse(Set.empty)
          .map { param =>
            val pValue = JsonApi.paramValueToJsValue(param.value) match {
              case JsString(value) => value
              case value => Json.stringify(value)
            }

            (param.name.value, pValue)
          }(collection.breakOut)

        (p.patternId.value, new util.LinkedHashMap[String, Any](Map(("active", true)) ++ parameters))
      }(collection.breakOut)

      (category.toLowerCase, new util.LinkedHashMap[String, Any](Map(("active", patternsRaw.nonEmpty)) ++ patterns))
    }).toMap

    val ourConf = new util.LinkedHashMap[String, Any](Map(("autoCorrect", false), ("failFast", false)) ++ configMapGen)

    new YamlConfig(ourConf)
  }

  private def getRules: Map[String, Seq[Rule]] = {
    val config = readEmptyConfigFile

    _root_.codacy.helpers.ResourceHelper
      .getResourceContent("META-INF/services/io.gitlab.arturbosch.detekt.api.RuleSetProvider")
      .get //This is just a script, is better get the error
      .map {
      clazz =>
        val provider = Class.forName(clazz)
          .getDeclaredConstructor()
          .newInstance()
          .asInstanceOf[RuleSetProvider]
          .instance(config)

        (provider.getId, provider.getRules
          .flatMap {
            case r: MultiRule =>
              r.asInstanceOf[MultiRule].getRules
            case r: Rule =>
              Seq(r.asInstanceOf[Rule])
          })
    }(collection.breakOut)
  }

  private def readEmptyConfigFile: Config = {
    new YamlConfig(new util.LinkedHashMap[String, Any](Map(("autoCorrect", false), ("failFast", false))))
  }

  private def getResults(path: Path, filesOpt: Option[Set[api.Source.File]], yamlConf: YamlConfig, parallel: Boolean): List[Finding] = {
    val settings = new ProcessingSettings(path, yamlConf, List.empty[PathFilter], parallel, false, List.empty[Path])

    val detektion: Detektion = filesOpt.fold {
      DetektFacade.INSTANCE.instance(settings).run(new KtTreeCompiler(path, settings.getPathFilters, parallel))
    } { files =>
      val compiler = new KtCompiler(path)

      val ktFiles: Seq[KtFile] = files.par.map(file => compiler.compile(Paths.get(file.path)))(collection.breakOut)

      DetektFacade.INSTANCE.instance(settings).run(new util.ArrayList(ktFiles))
    }

    detektion.getFindings.values.flatten.toList
  }

}
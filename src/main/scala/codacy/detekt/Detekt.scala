package codacy.detekt

import java.nio.file.{Path, Paths}
import java.util

import codacy.docker.api
import codacy.docker.api._
import codacy.dockerApi.utils.FileHelper
import io.gitlab.arturbosch.detekt.api._
import io.gitlab.arturbosch.detekt.core._
import org.yaml.snakeyaml.Yaml
import play.api.libs.json.{JsString, Json}

import scala.collection.JavaConversions._
import scala.io.Source
import scala.util.Try

object Detekt extends Tool {

  case class DetektCategory(value: String) extends AnyVal

  val configFiles = Set("default-detekt-config.yml", "detekt.yml")
  private lazy val patternIdToCategory: Map[Pattern.Id, DetektCategory] = {
    for {
      (cat, rules) <- getRules
      rule <- rules
    } yield Pattern.Id(rule.getRuleId) -> cat
  }

  override def apply(source: api.Source.Directory, configuration: Option[List[Pattern.Definition]], filesOpt: Option[Set[api.Source.File]])
                    (implicit specification: Tool.Specification): Try[List[Result]] = {
    Try {
      val sourcePath = Paths.get(source.path)
      val yamlConfig = getYamlConfig(configuration, sourcePath)

      val findings = getResults(sourcePath, filesOpt, yamlConfig, parallel = true)

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

  private def getYamlConfig(config: Option[List[Pattern.Definition]], source: Path)
                           (implicit specification: Tool.Specification): YamlConfig = {
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

  private def mapConfig(config: List[Pattern.Definition])(implicit specification: Tool.Specification): YamlConfig = {

    val configPatternsById: Map[Pattern.Id, Pattern.Definition] =
      config.map(patternDef => (patternDef.patternId, patternDef))(collection.breakOut)

    val configMapGen = specification.patterns.groupBy(patDef => patternIdToCategory(patDef.patternId)).map {
      case (cat, patternSpecs) =>
        cat -> patternSpecs.map(spec => (spec.patternId, configPatternsById.get(spec.patternId)))
    }.map { case (category, patternsRaw) =>

      val patterns: Map[String, Any] = patternsRaw.map { case (patternId, patternDef) =>
        val parameters: Map[String, Any] = patternDef.flatMap(_.parameters).getOrElse(Set.empty)
          .map { param =>
            val pValue = JsonApi.paramValueToJsValue(param.value) match {
              case JsString(value) => value
              case value => Json.stringify(value)
            }
            (param.name.value, pValue)
          }(collection.breakOut)

        val isInConfig = patternDef.isDefined
        (patternId.value, new util.LinkedHashMap[String, Any](Map(("active", isInConfig)) ++ parameters))
      }(collection.breakOut)

      (category.value.toLowerCase, new util.LinkedHashMap[String, Any](Map(("active", patternsRaw.nonEmpty)) ++ patterns))

    }

    val ourConf = new util.LinkedHashMap[String, Any](Map(("autoCorrect", false), ("failFast", false)) ++ configMapGen)

    new YamlConfig(ourConf)
  }

  private def getRules: Map[DetektCategory, Seq[Rule]] = {
    val config = readEmptyConfigFile

    _root_.codacy.helpers.ResourceHelper
      .getResourceContent("META-INF/services/io.gitlab.arturbosch.detekt.api.RuleSetProvider")
      .get //This is just a script, is better get the error
      .map {
      clazz =>
        val provider: RuleSet = Class.forName(clazz)
          .getDeclaredConstructor()
          .newInstance()
          .asInstanceOf[RuleSetProvider]
          .instance(config)

        (DetektCategory(provider.getId), provider.getRules
          .flatMap {
            case r: MultiRule =>
              r.getRules
            case r: Rule =>
              Seq(r)
          })
    }(collection.breakOut)
  }

  private def readEmptyConfigFile: Config = {
    new YamlConfig(new util.LinkedHashMap[String, Any](Map(("autoCorrect", false), ("failFast", false))))
  }

  private def getResults(path: Path, filesOpt: Option[Set[api.Source.File]], yamlConf: YamlConfig, parallel: Boolean): List[Finding] = {
    val settings = new ProcessingSettings(path, yamlConf, List.empty[PathFilter], parallel, false, List.empty[Path], null, null)
    val providers = new RuleSetLocator(settings).load()
    val processors = List.empty[FileProcessListener]
    val detektor = new Detektor(settings, providers, processors)
    val compiler = new KtTreeCompiler(new KtCompiler(), settings.getPathFilters, parallel, false)


    val detektion = filesOpt.fold {
      val ktFiles = compiler.compile(path)
      detektor.run(ktFiles)
    } { files =>
      val ktFiles = files.par.flatMap(file => compiler.compile(Paths.get(file.path))).to[List]
      detektor.run(ktFiles)
    }

    detektion.values.flatten.toList
  }

}
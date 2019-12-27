package codacy.detekt

import java.nio.file.{Path, Paths}
import better.files._
import java.util

import com.codacy.plugins.api
import com.codacy.plugins.api._
import com.codacy.plugins.api.results.{Pattern, Result, Tool}
import com.codacy.tools.scala.seed.utils.FileHelper
import io.gitlab.arturbosch.detekt.api._
import io.gitlab.arturbosch.detekt.core._
import org.jetbrains.kotlin.resolve.BindingContext
import org.yaml.snakeyaml.Yaml
import play.api.libs.json.{JsString, Json}

import scala.jdk.CollectionConverters._
import scala.util.Try

import scala.collection.parallel.CollectionConverters._

object Detekt extends Tool {

  private lazy val patternIdToCategory: Map[Pattern.Id, DetektCategory] = {
    for {
      (cat, rules) <- getRules
      rule <- rules
    } yield Pattern.Id(rule.getRuleId) -> cat
  }
  val configFiles = Set("default-detekt-config.yml", "detekt.yml")

  def apply(
      source: api.Source.Directory,
      configuration: Option[List[Pattern.Definition]],
      files: Option[Set[api.Source.File]],
      options: Map[Options.Key, Options.Value]
  )(implicit specification: Tool.Specification): Try[List[Result]] = {
    Try {
      val sourcePath = Paths.get(source.path)
      val yamlConfig = getYamlConfig(configuration, sourcePath)

      val findings = getResults(sourcePath, files, yamlConfig, parallel = true)

      findings.map { finding =>
        Result.Issue(
          api.Source.File(finding.getFile),
          Result.Message(finding.compact()),
          Pattern.Id(finding.getId),
          api.Source.Line(finding.getLocation.getSource.getLine)
        )
      }
    }
  }

  private def getYamlConfig(config: Option[List[Pattern.Definition]], source: Path)(
      implicit specification: Tool.Specification
  ): YamlConfig = config match {
    case None => defaultConfig(source)
    case Some(patternDefinition) => mapConfig(patternDefinition)
  }

  private def defaultConfig(source: Path): YamlConfig = {
    val map = FileHelper
      .findConfigurationFile(source, configFiles)
      .fold(new util.LinkedHashMap[String, Any]()) { configFile =>
        new Yaml()
          .load[util.LinkedHashMap[String, Any]](File(configFile).contentAsString)
      }
    new YamlConfig(map, null)
  }

  private def mapConfig(config: List[Pattern.Definition])(implicit specification: Tool.Specification): YamlConfig = {

    val configPatternsById: Map[Pattern.Id, Pattern.Definition] =
      config.view.map(patternDef => (patternDef.patternId, patternDef)).to(Map)

    val configMapGen = specification.patterns
      .groupBy(patDef => patternIdToCategory(patDef.patternId))
      .map {
        case (cat, patternSpecs) =>
          cat -> patternSpecs.map(spec => (spec.patternId, configPatternsById.get(spec.patternId)))
      }
      .map {
        case (category, patternsRaw) =>
          val patterns = patternsRaw.view.map {
            case (patternId, patternDef) =>
              val parameters = patternDef
                .flatMap(_.parameters)
                .getOrElse(Set.empty)
                .map { param =>
                  val pValue = paramValueToJsValue(param.value) match {
                    case JsString(value) => value
                    case value => Json.stringify(value)
                  }
                  (param.name.value, pValue)
                }

              val isInConfig = patternDef.isDefined
              (patternId.value, (Map(("active", isInConfig)) ++ parameters).asJava)
          }

          (category.value.toLowerCase, (Map(("active", patternsRaw.nonEmpty)) ++ patterns).asJava)
      }

    val ourConf = Map(("autoCorrect", false), ("failFast", false)) ++ configMapGen

    new YamlConfig(ourConf.asJava, null)
  }

  private def getResults(
      path: Path,
      filesOpt: Option[Set[api.Source.File]],
      yamlConf: YamlConfig,
      parallel: Boolean
  ): List[Finding] = {
    val settings = new ProcessingSettings(List(path).asJava, yamlConf, null, parallel)
    val providers = new RuleSetLocator(settings).load()
    val processors = List.empty[FileProcessListener]
    val detektor = new Detektor(settings, providers, processors.asJava)
    val compiler = new KtTreeCompiler(settings, new KtCompiler())

    val detektion = filesOpt match {
      case None =>
        val ktFiles = compiler.compile(path)
        detektor.run(ktFiles, BindingContext.EMPTY)
      case Some(files) =>
        val ktFiles = files.par.flatMap(file => compiler.compile(Paths.get(file.path)).asScala).seq.asJava
        detektor.run(ktFiles, BindingContext.EMPTY)
    }

    detektion.values.asScala.flatMap(_.asScala).toList
  }

  private def getRules: Map[DetektCategory, Seq[Rule]] = {
    val config = readEmptyConfigFile

    Providers.list.view.map { provider =>
      val ruleSet: RuleSet = provider.instance(config)
      DetektCategory(ruleSet.getId) -> ruleSet.getRules.asScala.flatMap {
        case r: MultiRule =>
          r.getRules.asScala
        case r: Rule =>
          Seq(r)
      }.toSeq
    }.toMap
  }

  private def readEmptyConfigFile: Config = {
    new YamlConfig(Map(("autoCorrect", false), ("failFast", false)).asJava, null)
  }

  case class DetektCategory(value: String) extends AnyVal

}

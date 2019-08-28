package codacy.detekt

import better.files.File
import codacy.helpers.ResourceHelper
import io.gitlab.arturbosch.detekt.api._
import io.gitlab.arturbosch.detekt.core.{KtCompiler, KtTreeCompiler, ProcessingSettings}
import io.gitlab.arturbosch.detekt.generator.collection.DetektCollector
import org.jetbrains.kotlin.psi.KtFile
import play.api.libs.json.{JsArray, Json}

import scala.collection.JavaConverters._
import scala.sys.process.Process

object DocGenerator {
  def main(args: Array[String]): Unit = {
    args.headOption.fold {
      throw new Exception("Version parameter is required (ex: 1.0.0.RC6-4)")
    } { version =>
      val rules = generateRules

      val repoRoot = new java.io.File(".")
      val docsRoot = new java.io.File(repoRoot, "src/main/resources/docs")
      val patternsFile = new java.io.File(docsRoot, "patterns.json")
      val descriptionsRoot = new java.io.File(docsRoot, "description")
      val descriptionsFile =
        new java.io.File(descriptionsRoot, "description.json")

      val extendedDescriptions = getExtendedDescriptions(version)

      val patterns = Json.prettyPrint(
        Json.obj("name" -> "Detekt",
          "version" -> version,
          "patterns" -> Json
            .parse(Json.toJson(generatePatterns(rules)).toString)
            .as[JsArray]))

      val descriptions = Json.prettyPrint(
        Json
          .parse(
            Json
              .toJson(generateDescriptions(rules,
                descriptionsRoot,
                extendedDescriptions))
              .toString)
          .as[JsArray])

      ResourceHelper.writeFile(patternsFile.toPath, patterns)
      ResourceHelper.writeFile(descriptionsFile.toPath, descriptions)
    }
  }

  private def generatePatterns(rules: List[Rule]): JsArray = {
    val codacyPatterns = rules.map { rule =>
      val category =
        if (rule.getIssue.getSeverity.name.startsWith("Defect") ||
          rule.getIssue.getSeverity.name.startsWith("Maintainability") ||
          rule.getIssue.getSeverity.name.startsWith("Minor")) {
          "ErrorProne"
        } else if (rule.getIssue.getSeverity.name.startsWith("Performance")) {
          "Performance"
        } else {
          "CodeStyle"
        }

      val level =
        if (rule.getIssue.getSeverity.name.startsWith("Maintainability") ||
          rule.getIssue.getSeverity.name.startsWith("Warning") ||
          rule.getIssue.getSeverity.name.startsWith("Minor") ||
          rule.getIssue.getSeverity.name.startsWith("Performance") ||
          rule.getIssue.getSeverity.name.startsWith("Defect")) {
          "Warning"
        } else {
          "Info"
        }

      Json.obj(
        "patternId" -> rule.getIssue.getId,
        "level" -> level,
        "category" -> category
      )
    }
    Json.parse(Json.toJson(codacyPatterns).toString).as[JsArray]
  }

  private def generateDescriptions(
                                    rules: List[Rule],
                                    descriptionsRoot: java.io.File,
                                    extendedDescriptions: Map[String, String]): JsArray = {
    val codacyPatternsDescs = rules.collect {
      case rule =>
        val descriptionsFile =
          new java.io.File(descriptionsRoot, s"${rule.getIssue.getId}.md")
        ResourceHelper.writeFile(descriptionsFile.toPath,
          extendedDescriptions(rule.getRuleId))

        Json.obj(
          "patternId" -> rule.getIssue.getId,
          "title" -> Json.toJsFieldJsValueWrapper(
            Option(truncateText(rule, 250))
              .filter(_.nonEmpty)
              .getOrElse(rule.getIssue.getId)),
          "timeToFix" -> 5
        ) ++
          Option(truncateText(rule, 495))
            .filter(_.nonEmpty)
            .fold(Json.obj())(desc => Json.obj("description" -> desc))
    }

    Json.parse(Json.toJson(codacyPatternsDescs).toString).as[JsArray]
  }

  private def truncateText(rule: Rule, maxCharacters: Int): String = {
    val description = rule.getIssue.getDescription
    if (description.length > maxCharacters) {
      description
        .take(maxCharacters)
        .split("\\.")
        .dropRight(1)
        .mkString(".") + "."
    } else {
      description
    }
  }

  private def generateRules: List[Rule] = {
    val config = new YamlConfig((Map(("autoCorrect", false), ("failFast", false))).asJava, null)

    _root_.codacy.helpers.ResourceHelper
      .getResourceContent(
        "META-INF/services/io.gitlab.arturbosch.detekt.api.RuleSetProvider")
      .get //This is just a script, is better get the error
      .flatMap { clazz =>
        Class
          .forName(clazz)
          .getDeclaredConstructor()
          .newInstance()
          .asInstanceOf[RuleSetProvider]
          .instance(config)
          .getRules
          .asScala
          .flatMap {
            case r: MultiRule =>
              r.asInstanceOf[MultiRule].getRules.asScala
            case r: Rule =>
              Seq(r.asInstanceOf[Rule])
          }
      }(collection.breakOut)
  }

  private def getExtendedDescriptions(version: String): Map[String, String] = {
    val tmpDirectory = File.newTemporaryDirectory()

    Process(
      Seq("git",
        "clone",
        "--branch",
        version,
        "git://github.com/arturbosch/detekt",
        tmpDirectory.pathAsString)).!

    val filePaths = better.files
      .File(s"${tmpDirectory.pathAsString}/detekt-rules/src/main")
      .listRecursively()
      .filter(_.pathAsString.endsWith(".kt"))
      .map(_.path)

    val collector = new DetektCollector()
    val compiler = new KtTreeCompiler(new ProcessingSettings(List.empty.asJava), new KtCompiler())

    val ktFiles: Array[KtFile] = filePaths
      .to[Array]
      .flatMap(file => compiler.compile(file).asScala)
    ktFiles.foreach(file => collector.visit(file))

    tmpDirectory.delete(swallowIOExceptions = true)

    collector.getItems
      .asScala
      .to[List]
      .flatMap(
        ruleSet =>
          ruleSet.getRules
            .asScala
            .map(
              rule =>
                (rule.getName,
                  generateMarkdown(ruleSet.getRuleSet.getName,
                    rule.getName,
                    rule.getDescription,
                    rule.getNonCompliantCodeExample,
                    rule.getCompliantCodeExample))))(
        collection.breakOut)
  }

  private def generateMarkdown(ruleSetName: String,
                               ruleName: String,
                               description: String,
                               nonCompliantCodeExample: String,
                               compliantCodeExample: String): String = {
    val nonCompliantCodeExampleMarkdown =
      if (nonCompliantCodeExample.trim.nonEmpty) {
        s"""|
            |## Noncompliant Code
            |
            |```kotlin
            |$nonCompliantCodeExample
            |```""".stripMargin
      } else {
        ""
      }

    val compliantCodeExampleMarkdown =
      if (compliantCodeExample.trim.nonEmpty) {
        s"""|
            |## Compliant Code
            |
            |```kotlin
            |$compliantCodeExample
            |```""".stripMargin
      } else {
        ""
      }

    s"""|# $ruleName
        |
        |$description
        |$nonCompliantCodeExampleMarkdown$compliantCodeExampleMarkdown
        |
        |[Source](https://arturbosch.github.io/detekt/${ruleSetName.toLowerCase}.html#${ruleName.toLowerCase})
        |""".stripMargin
  }
}

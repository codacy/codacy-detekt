package codacy.detekt

import java.util

import codacy.helpers.ResourceHelper
import io.gitlab.arturbosch.detekt.api._
import play.api.libs.json.{JsArray, Json}

import scala.collection.JavaConversions._

object DocGenerator {
  def main(args: Array[String]): Unit = {
    args.headOption.fold {
      throw new Exception("Version parameter is required (ex: 1.0.0.RC4-3)")
    } { version =>
      val rules = generateRules

      val repoRoot = new java.io.File(".")
      val docsRoot = new java.io.File(repoRoot, "src/main/resources/docs")
      val patternsFile = new java.io.File(docsRoot, "patterns.json")
      val descriptionsRoot = new java.io.File(docsRoot, "description")
      val descriptionsFile = new java.io.File(descriptionsRoot, "description.json")

      val patterns = Json.prettyPrint(Json.obj("name" -> "Detekt", "version" -> version, "patterns" -> Json.parse(Json.toJson(generatePatterns(rules)).toString).as[JsArray]))

      val descriptions = Json.prettyPrint(Json.parse(Json.toJson(generateDescriptions(rules, descriptionsRoot)).toString).as[JsArray])

      ResourceHelper.writeFile(patternsFile.toPath, patterns)
      ResourceHelper.writeFile(descriptionsFile.toPath, descriptions)
    }
  }

  private def generatePatterns(rules: List[Rule]): JsArray = {
    val codacyPatterns = rules.collect { case (rule) =>
      Json.obj(
        "patternId" -> rule.getIssue.getId,
        "level" -> (if (rule.getIssue.getSeverity.name.startsWith("Maintainability") || rule.getIssue.getSeverity.name.startsWith("Warning") || rule.getIssue.getSeverity.name.startsWith("Minor") || rule.getIssue.getSeverity.name.startsWith("Performance") || rule.getIssue.getSeverity.name.startsWith("Defect")) "Warning" else "Info"),
        "category" -> (if (rule.getIssue.getSeverity.name.startsWith("Defect") || rule.getIssue.getSeverity.name.startsWith("Maintainability") || rule.getIssue.getSeverity.name.startsWith("Minor")) "ErrorProne" else if (rule.getIssue.getSeverity.name.startsWith("Performance")) "Performance" else "CodeStyle")
      )
    }
    Json.parse(Json.toJson(codacyPatterns).toString).as[JsArray]
  }

  private def generateDescriptions(rules: List[Rule], descriptionsRoot: java.io.File): JsArray = {
    val codacyPatternsDescs = rules.collect { case (rule) =>

      if(rule.getIssue.getDescription.length > 495) {
        val descriptionsFile = new java.io.File(descriptionsRoot, s"${rule.getIssue.getId}.md")
        ResourceHelper.writeFile(descriptionsFile.toPath, rule.getIssue.getDescription)
      }

      Json.obj(
        "patternId" -> rule.getIssue.getId,
        "title" -> Json.toJsFieldJsValueWrapper(Option(truncateText(rule, 250)).filter(_.nonEmpty).getOrElse(rule.getIssue.getId)),
        "timeToFix" -> 5
      ) ++
        Option(truncateText(rule, 495)).filter(_.nonEmpty)
          .fold(Json.obj())(desc => Json.obj("description" -> desc))
    }

    Json.parse(Json.toJson(codacyPatternsDescs).toString).as[JsArray]
  }

  private def truncateText(rule: Rule, maxCharacters: Int): String = {
    val description = rule.getIssue.getDescription
    if (description.length > maxCharacters) {
      description.take(maxCharacters).split("\\.").dropRight(1).mkString(".") + "."
    } else {
      description
    }
  }

  private def generateRules: List[Rule] = {
    val config = new YamlConfig(new util.LinkedHashMap[String, Any](Map(("autoCorrect", false), ("failFast", false))))

    _root_.codacy.helpers.ResourceHelper.getResourceContent("META-INF/services/io.gitlab.arturbosch.detekt.api.RuleSetProvider")
      .get //This is just a script, is better get the error
      .flatMap {
      clazz =>
        Class.forName(clazz)
          .getDeclaredConstructor()
          .newInstance()
          .asInstanceOf[RuleSetProvider]
          .instance(config)
          .getRules
          .flatMap {
            case r: MultiRule =>
              r.asInstanceOf[MultiRule].getRules
            case r: Rule =>
              Seq(r.asInstanceOf[Rule])
          }
    }(collection.breakOut)
  }
}
import java.util

import io.gitlab.arturbosch.detekt.api.{MultiRule, Rule, RuleSetProvider, YamlConfig}
import play.api.libs.json._

import scala.collection.JavaConversions._

def updatePatternsAndDescription(version: String): Unit = {
  val rules = generateRules
  val patterns = generatePatterns(rules)
  println(s"\n${Json.obj("name" -> "Detekt", "version" -> version, "patterns" -> Json.parse(Json.toJson(patterns).toString).as[JsArray])}\n")

  val descriptions = generateDescriptions(rules)
  println(s"\n${Json.parse(Json.toJson(descriptions).toString).as[JsArray]}\n")
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

private def generateDescriptions(rules: List[Rule]): JsArray = {
  val codacyPatternsDescs = rules.collect { case (rule) =>
    Json.obj(
      "patternId" -> rule.getIssue.getId,
      "title" -> Json.toJsFieldJsValueWrapper(Option(rule.getIssue.getDescription).filter(_.nonEmpty).getOrElse(rule.getIssue.getId)),
      "timeToFix" -> 5
    ) ++
      Option(rule.getIssue.getDescription).filter(_.nonEmpty)
        .fold(Json.obj())(desc => Json.obj("description" -> desc))
  }

  Json.parse(Json.toJson(codacyPatternsDescs).toString).as[JsArray]
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
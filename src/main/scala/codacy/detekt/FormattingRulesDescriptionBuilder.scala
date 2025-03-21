package codacy.detekt

import java.net.URL
import scala.io.Source
import scala.util.{Failure, Success, Using}

object FormattingRulesDescriptionBuilder {

  def build(rules: List[String], commit: String, version: String): List[RuleDetails] = {

    val ruleSetName = "formatting"

    val docsUrl = new URL(
      s"https://raw.githubusercontent.com/detekt/detekt/$commit/website/versioned_docs/version-$version/rules/$ruleSetName.md"
    )

    def formattingDocsUrl(formattingDocsVersion: String, file: String) =
      s"https://raw.githubusercontent.com/pinterest/ktlint/refs/tags/$formattingDocsVersion/documentation/snapshot/docs/rules/$file.md"

    val content = Using(Source.fromURL(docsUrl)) { reader =>
      reader.mkString
    } match {
      case Failure(_) => None
      case Success(value) => Some(value)
    }

    val rulesDocs = content.map(_.split("###").toList)

    val rulesMap = rulesDocs.map(
      _.filter(_.contains("[ktlint docs]"))
        .flatMap(extractRuleNameAndVersionAndFolderAndOriginalName)
        .map(rule => rule.ruleName -> rule)
        .toMap
    )

    val versionAndFolders = rulesMap.map(_.map {
      case (_, RuleInformation(_, version, folder, _)) =>
        VersionAndFile(version, folder)
    }.toSet)

    val rulesByVersionFolder = versionAndFolders.map(_.map {
      case VersionAndFile(version, folder) =>
        (version, folder) -> (Using(Source.fromURL(formattingDocsUrl(version, folder))) { reader =>
          reader.mkString.replace("###", "##")
        } match {
          case Failure(_) => None
          case Success(value) => Some(value)
        })
    }.toMap)

    rules.map(
      rule =>
        rulesMap.flatMap(_.get(rule).flatMap {
          case RuleInformation(_, version, folder, originalName) =>
            rulesByVersionFolder
              .get((version, folder))
              .flatMap(
                raw =>
                  extractNameAndDescriptionAndCompliantAndNonCompliantCode(raw, originalName) match {
                    case Some((description, compliantCode, nonCompliantCode)) =>
                      Some(RuleDetails(ruleSetName, rule, description, nonCompliantCode, compliantCode))
                    case _ => None
                }
              )
        })
    )
  }.flatten

  private def extractRuleNameAndVersionAndFolderAndOriginalName(rawRule: String): Option[RuleInformation] = {

    val rawRuleSplit = rawRule.split("\n").filter(_.nonEmpty)

    rawRuleSplit.headOption
      .map(_.trim)
      .flatMap(_ => {
        rawRuleSplit.tail.headOption
          .flatMap(
            stuff =>
              stuff.split("/").toList match {
                case List(_, _, _, _, version, _, folder, originalName) =>
                  originalName
                    .split("\\)")
                    .headOption
                    .map(name => Some(RuleInformation(name, version, folder, name)))
                case _ =>
                  stuff.split("/").foreach(println)
                  None
            }
          )
      })
  }.flatten

  private def extractNameAndDescriptionAndCompliantAndNonCompliantCode(
      raw: String,
      originalName: String
  ): Option[(String, Option[String], Option[String])] = {

    val originalNameNormalized = normalizeName(originalName)

    val rawSplit = raw.split("Rule id:")

    val ruleMdChunk = rawSplit.find(_.contains(originalNameNormalized))

    val ruleMd = ruleMdChunk.flatMap(_.split(originalNameNormalized).headOption)

    ruleMd.flatMap(rule => {
      rule
        .split("===")
        .headOption
        .map(_.trim)
        .map(desc => {

          val hasCompliantCode = rule.contains("""=== "[:material-heart:](#) Ktlint"""")
          val hasNonCompliantCode = rule.contains("""=== "[:material-heart-off-outline:](#) Disallowed"""")

          val compliantCodeSplit = rule.split("""Ktlint"""")

          val compliantCode =
            if (hasCompliantCode)
              extractCode(compliantCodeSplit)
            else None

          val nonCompliantCodeSplit = rule.split("""Disallowed"""")

          val nonCompliantCode =
            if (hasNonCompliantCode)
              extractCode(nonCompliantCodeSplit)
            else None

          (desc, compliantCode, nonCompliantCode)
        })
    })
  }

  private def extractCode(codeChunks: Array[String]): Option[String] =
    codeChunks.tail.headOption
      .filter(_.contains("kotlin"))
      .flatMap(_.split("kotlin").tail.headOption.flatMap(_.split("```").headOption))

  private def normalizeName(snakeCaseName: String): String =
    s"## ${capitalizeFirstLetter(snakeCaseName.split("-").mkString(" "))}"

  private def capitalizeFirstLetter(input: String): String = {
    if (input.isEmpty) {
      input
    } else {
      input.head.toUpper + input.tail.toLowerCase
    }
  }

  private case class RuleInformation(ruleName: String, version: String, folder: String, originalName: String)

  private case class VersionAndFile(version: String, file: String)

}

case class RuleDetails(
    ruleSetName: String,
    ruleName: String,
    description: String,
    nonCompliantCodeExample: Option[String],
    compliantCodeExample: Option[String]
)

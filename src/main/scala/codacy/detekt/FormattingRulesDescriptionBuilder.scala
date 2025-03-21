package codacy.detekt

import java.net.URL
import scala.io.Source

object FormattingRulesDescriptionBuilder extends App {

  def build(rules: List[String], commit: String, version: String): List[RuleDetails] = {

    val ruleSetName = "formatting"

    val docsUrl = new URL(
      s"https://raw.githubusercontent.com/detekt/detekt/$commit/website/versioned_docs/version-$version/rules/$ruleSetName.md"
    )

    def formattingDocsUrl(formattingDocsVersion: String, file: String) =
      s"https://raw.githubusercontent.com/pinterest/ktlint/refs/tags/$formattingDocsVersion/documentation/snapshot/docs/rules/$file.md"

    val content = Source.fromURL(docsUrl).mkString

    val rulesDocs = content.split("###").toList

    val rulesMap = rulesDocs
      .filter(_.contains("[ktlint docs]"))
      .map(extractRuleNameAndVersionAndFolderAndOriginalName)
      .map(rule => rule.ruleName -> rule)
      .toMap

    val versionAndFolders = rulesMap.map {
      case (_, RuleInformation(_, version, folder, _)) =>
        VersionAndFile(version, folder)
    }.toSet

    val rulesByVersionFolder = versionAndFolders.map {
      case VersionAndFile(version, folder) =>
        (version, folder) -> Source.fromURL(formattingDocsUrl(version, folder)).mkString.replace("###", "##")
    }.toMap

    rules.map(
      rule =>
        rulesMap.get(rule).flatMap {
          case RuleInformation(_, version, folder, originalName) =>
            rulesByVersionFolder
              .get((version, folder))
              .flatMap(raw => {
                extractNameAndDescriptionAndCompliantAndNonCompliantCode(raw, originalName) match {
                  case Some((description, compliantCode, nonCompliantCode)) =>
                    Some(RuleDetails(ruleSetName, rule, description, nonCompliantCode, compliantCode))

                  case None => None
                }
              })
      }
    )
  }.flatten

  private def extractRuleNameAndVersionAndFolderAndOriginalName(rawRule: String): RuleInformation = {

    val rawRuleSplit = rawRule.split("\n").filter(_.nonEmpty)

    val ruleName = rawRuleSplit(0).trim

    val ruleUrl = rawRuleSplit(1).split("/")

    val version = ruleUrl(4).trim
    val folder = ruleUrl(6).trim
    val originalName = ruleUrl(7).split("\\)")(0).tail.trim

    RuleInformation(ruleName, version, folder, originalName)
  }

  private def extractNameAndDescriptionAndCompliantAndNonCompliantCode(
      raw: String,
      originalName: String
  ): Option[(String, Option[String], Option[String])] = {

    val originalNameNormalized = normalizeName(originalName)

    val rawSplit = raw.split("Rule id:")

    val ruleMdChunk = rawSplit.find(_.contains(originalNameNormalized))

    val ruleMd = ruleMdChunk.map(_.split(originalNameNormalized)(1))

    ruleMd.map(rule => {
      val description = rule.split("===")(0).trim

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

      (description, compliantCode, nonCompliantCode)
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

  val rules = List(
    "AnnotationOnSeparateLine",
    "AnnotationSpacing",
    "ArgumentListWrapping",
    "BlockCommentInitialStarAlignment",
    "ChainWrapping",
    "ClassName",
    "CommentSpacing",
    "CommentWrapping",
    "EnumEntryNameCase",
    "Filename",
    "FinalNewline",
    "FunctionName",
    "FunKeywordSpacing",
    "FunctionReturnTypeSpacing",
    "FunctionStartOfBodySpacing",
    "FunctionTypeReferenceSpacing",
    "ImportOrdering",
    "Indentation",
    "KdocWrapping",
    "MaximumLineLength",
    "ModifierListSpacing",
    "ModifierOrdering",
    "MultiLineIfElse",
    "NoBlankLineBeforeRbrace",
    "NoBlankLinesInChainedMethodCalls",
    "NoConsecutiveBlankLines",
    "NoEmptyClassBody",
    "NoEmptyFirstLineInMethodBlock",
    "NoLineBreakAfterElse",
    "NoLineBreakBeforeAssignment",
    "NoMultipleSpaces",
    "NoSemicolons",
    "NoTrailingSpaces",
    "NoUnitReturn",
    "NoUnusedImports",
    "NoWildcardImports",
    "NullableTypeSpacing",
    "PackageName",
    "ParameterListWrapping",
    "ParameterWrapping",
    "PropertyName",
    "PropertyWrapping",
    "SpacingAroundAngleBrackets",
    "SpacingAroundColon",
    "SpacingAroundComma",
    "SpacingAroundCurly",
    "SpacingAroundDot",
    "SpacingAroundDoubleColon",
    "SpacingAroundKeyword",
    "SpacingAroundOperators",
    "SpacingAroundParens",
    "SpacingAroundRangeOperator",
    "SpacingAroundUnaryOperator",
    "SpacingBetweenDeclarationsWithAnnotations",
    "SpacingBetweenDeclarationsWithComments",
    "SpacingBetweenFunctionNameAndOpeningParenthesis",
    "StringTemplate",
    "TrailingCommaOnCallSite",
    "TrailingCommaOnDeclarationSite",
    "UnnecessaryParenthesesBeforeTrailingLambda",
    "Wrapping",
    "ContextReceiverMapping",
    "DiscouragedCommentLocation",
    "EnumWrapping",
    "FunctionSignature",
    "IfElseBracing",
    "IfElseWrapping",
    "MultilineExpressionWrapping",
    "NoBlankLineInList",
    "NoConsecutiveComments",
    "NoEmptyFirstLineInClassBody",
    "NoSingleLineBlockComment",
    "ParameterListSpacing",
    "StringTemplateIndent",
    "TryCatchFinallySpacing",
    "TypeArgumentListSpacing",
    "TypeParameterListSpacing",
  )

  build(rules, "b151e99bc55dd23c3cdd995cb2f2244f1832a3a5", "1.23.8")
}

case class RuleDetails(
    ruleSetName: String,
    ruleName: String,
    description: String,
    nonCompliantCodeExample: Option[String],
    compliantCodeExample: Option[String]
)

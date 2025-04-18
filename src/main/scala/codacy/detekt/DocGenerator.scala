package codacy.detekt

import better.files.File
import io.github.detekt.parser.KtCompiler
import io.github.detekt.tooling.dsl.ProjectSpecBuilder
import io.gitlab.arturbosch.detekt.api._
import io.gitlab.arturbosch.detekt.core.KtTreeCompiler
import io.gitlab.arturbosch.detekt.formatting.FormattingProvider
import io.gitlab.arturbosch.detekt.generator.collection.DetektCollector
import org.jetbrains.kotlin.psi.KtFile
import play.api.libs.json.{JsArray, Json}

import scala.jdk.CollectionConverters._
import scala.sys.process.Process

object DocGenerator {

  private val defaultPatterns = List(
    "EmptyCatchBlock",
    "StringLiteralDuplication",
    "CommentOverPrivateFunction",
    "ComplexCondition",
    "EqualsWithHashCodeExist",
    "TooGenericExceptionThrown",
    "UnsafeCallOnNullableType",
    "EmptyInitBlock",
    "UndocumentedPublicClass",
    "SpreadOperator",
    "ForEachOnRange",
    "EmptyIfBlock",
    "EmptySecondaryConstructor",
    "LongMethod",
    "TooGenericExceptionCaught",
    "LabeledExpression",
    "RethrowCaughtException",
    "EqualsAlwaysReturnsTrueOrFalse",
    "UnnecessaryTemporaryInstantiation",
    "EmptyFunctionBlock",
    "EmptyForBlock",
    "EmptyFinallyBlock",
    "UndocumentedPublicFunction",
    "CommentOverPrivateProperty",
    "ComplexMethod",
    "EmptyClassBlock",
    "EmptyDefaultConstructor",
    "IteratorNotThrowingNoSuchElementException",
    "LargeClass",
    "ReturnFromFinally",
    "ThrowingExceptionFromFinally",
    "TooManyFunctions",
    "UnsafeCast",
    "UselessPostfixExpression",
    "WrongEqualsTypeParameter",
    "ExplicitGarbageCollectionCall",
    "EmptyDoWhileBlock",
    "NestedBlockDepth",
    "EmptyElseBlock",
    "EmptyWhileBlock",
    "EmptyWhenBlock",
    "LongParameterList",
    "ThrowingNewInstanceOfSameException"
  )

  def main(args: Array[String]): Unit = {
    val rules = generateRules

    val repoRoot = File(".")
    val docsRoot = repoRoot / "docs"
    docsRoot.createIfNotExists(asDirectory = true)
    val patternsFile = docsRoot / "patterns.json"
    val descriptionsRoot = docsRoot / "description"
    descriptionsRoot.createIfNotExists(asDirectory = true)
    val descriptionsFile = descriptionsRoot / "description.json"

    val extendedDescriptions = getExtendedDescriptions(Versions.detektVersion)

    val extendedFormattingRulesDescriptions =
      getExtendedFormattingDescriptions(formattingRuleIds, Versions.commit, Versions.detektVersion)

    val patterns = Json.prettyPrint(
      Json.obj(
        "name" -> "detekt",
        "version" -> Versions.detektVersion,
        "patterns" -> Json
          .parse(Json.toJson(generatePatterns(rules)).toString)
          .as[JsArray]
      )
    )

    val descriptions = Json.prettyPrint(
      Json
        .parse(
          Json
            .toJson(
              generateDescriptions(rules, descriptionsRoot, extendedDescriptions ++ extendedFormattingRulesDescriptions)
            )
            .toString
        )
        .as[JsArray]
    )

    patternsFile.write(patterns)
    descriptionsFile.write(descriptions)
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
        "category" -> category,
        "enabled" -> defaultPatterns.contains(rule.getIssue.getId)
      )
    }
    Json.parse(Json.toJson(codacyPatterns).toString).as[JsArray]
  }

  private def generateDescriptions(
      rules: List[Rule],
      descriptionsRoot: File,
      extendedDescriptions: Map[String, String]
  ): JsArray = {
    val codacyPatternsDescs = rules.map { rule =>
      val descriptionsFile = descriptionsRoot / s"${rule.getIssue.getId}.md"
      extendedDescriptions.get(rule.getRuleId).foreach(descriptionsFile.write)

      Json.obj(
        "patternId" -> rule.getIssue.getId,
        "title" -> Json.toJsFieldJsValueWrapper(
          Option(truncateText(rule, 250))
            .filter(_.nonEmpty)
            .getOrElse(rule.getIssue.getId)
        ),
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

  private def generateRules: List[Rule] =
    for {
      provider <- Providers.list
      properties = Map("autoCorrect" -> false, "failFast" -> false).asJava
      config = YamlConfigFactory.create(properties)
      rules <- provider
        .instance(config)
        .getRules
        .asScala
      flattenedRules <- rules match {
        case r: MultiRule =>
          r.getRules.asScala
        case r: Rule =>
          Seq(r)
        case _: BaseRule =>
          Seq.empty
      }
    } yield flattenedRules

  private lazy val formattingRuleIds: List[String] = {
    val provider = new FormattingProvider
    val properties = Map("autoCorrect" -> false, "failFast" -> false).asJava
    val config = YamlConfigFactory.create(properties)
    for {
      rules <- provider
        .instance(config)
        .getRules
        .asScala
      flattenedRules <- rules match {
        case r: MultiRule =>
          r.getRules.asScala
        case r: Rule =>
          Seq(r)
        case _: BaseRule =>
          Seq.empty
      }
    } yield flattenedRules.getRuleId
  }.toList

  private def getExtendedDescriptions(version: String): Map[String, String] = {
    val tmpDirectory = File.newTemporaryDirectory()

    Process(
      Seq("git", "clone", "--branch", s"v$version", "https://github.com/detekt/detekt", tmpDirectory.pathAsString)
    ).!

    val detektRootFolder = File(tmpDirectory.pathAsString)

    val filePaths = detektRootFolder.children
      .filter(isDetektRuleFolder)
      .flatMap(dir => (dir / "src" / "main").listRecursively())
      .filter(_.pathAsString.endsWith(".kt"))
      .map(_.path)

    val collector = new DetektCollector(Map.empty.asJava)
    val processingSettings = ProcessingSettingsFactory.create(Seq.empty.asJava)
    val compiler = new KtTreeCompiler(processingSettings, new ProjectSpecBuilder().build(), new KtCompiler())

    val ktFiles: Array[KtFile] = filePaths
      .to(Array)
      .flatMap(file => compiler.compile(file).asScala)

    ktFiles.foreach(file => collector.visit(file))

    tmpDirectory.delete(swallowIOExceptions = true)

    collector.getItems.asScala.view
      .flatMap(
        ruleSet =>
          ruleSet.getRules.asScala
            .map(
              rule =>
                (
                  rule.getName,
                  generateMarkdown(
                    ruleSet.getRuleSet.getName,
                    rule.getName,
                    rule.getDescription,
                    rule.getNonCompliantCodeExample,
                    rule.getCompliantCodeExample
                  )
              )
          )
      )
      .to(Map)
  }

  private def getExtendedFormattingDescriptions(
      rules: List[String],
      commit: String,
      version: String
  ): Map[String, String] = {

    FormattingRulesDescriptionBuilder
      .build(rules, commit, version)
      .map(
        rule =>
          (
            rule.ruleName,
            generateMarkdown(
              rule.ruleSetName,
              rule.ruleName,
              rule.description,
              rule.nonCompliantCodeExample.getOrElse(""),
              rule.compliantCodeExample.getOrElse("")
            )
        )
      )
      .toMap
  }

  private def isDetektRuleFolder(file: File) = {
    file.isDirectory && file.name.startsWith("detekt-rules-")
  }

  private def generateMarkdown(
      ruleSetName: String,
      ruleName: String,
      description: String,
      nonCompliantCodeExample: String,
      compliantCodeExample: String
  ): String = {
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
        |[Source](https://detekt.dev/docs/rules/${ruleSetName.toLowerCase}#${ruleName.toLowerCase})
        |""".stripMargin
  }
}

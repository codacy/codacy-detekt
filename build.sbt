name := "codacy-detekt"

scalaVersion := "2.13.12"
kotlinVersion := "1.9.22"

lazy val detektVersion = Def.setting("1.23.7")

Compile / sourceGenerators += Def.task {
  val file = (Compile / sourceManaged).value / "codacy" / "detekt" / "Versions.scala"
  IO.write(file, s"""package codacy.detekt
                    |object Versions {
                    |  val detektVersion: String = "${detektVersion.value}"
                    |}
                    |""".stripMargin)
  Seq(file)
}.taskValue

resolvers += Resolver.jcenterRepo

libraryDependencies ++= {
  Seq(
    "com.codacy" %% "codacy-engine-scala-seed" % "6.1.2",
    "com.github.pathikrit" %% "better-files" % "3.9.2",
    "org.scala-lang.modules" %% "scala-xml" % "1.3.0",
    "io.gitlab.arturbosch.detekt" % "detekt-core" % detektVersion.value,
    "io.gitlab.arturbosch.detekt" % "detekt-formatting" % detektVersion.value,
    "io.gitlab.arturbosch.detekt" % "detekt-api" % detektVersion.value,
    "io.gitlab.arturbosch.detekt" % "detekt-rules" % detektVersion.value,
    "io.gitlab.arturbosch.detekt" % "detekt-cli" % detektVersion.value,
    "io.gitlab.arturbosch.detekt" % "detekt-generator" % detektVersion.value,
    "io.gitlab.arturbosch.detekt" % "detekt-gradle-plugin" % detektVersion.value,
    "io.gitlab.arturbosch.detekt" % "detekt-metrics" % detektVersion.value,
    "io.gitlab.arturbosch.detekt" % "detekt-parser" % detektVersion.value,
    "io.gitlab.arturbosch.detekt" % "detekt-psi-utils" % detektVersion.value,
    "io.gitlab.arturbosch.detekt" % "detekt-report-html" % detektVersion.value,
    "io.gitlab.arturbosch.detekt" % "detekt-report-md" % detektVersion.value,
    "io.gitlab.arturbosch.detekt" % "detekt-report-sarif" % detektVersion.value,
    "io.gitlab.arturbosch.detekt" % "detekt-report-txt" % detektVersion.value,
    "io.gitlab.arturbosch.detekt" % "detekt-report-xml" % detektVersion.value,
    "io.gitlab.arturbosch.detekt" % "detekt-rules-complexity" % detektVersion.value,
    "io.gitlab.arturbosch.detekt" % "detekt-rules-coroutines" % detektVersion.value,
    "io.gitlab.arturbosch.detekt" % "detekt-rules-documentation" % detektVersion.value,
    "io.gitlab.arturbosch.detekt" % "detekt-rules-empty" % detektVersion.value,
    "io.gitlab.arturbosch.detekt" % "detekt-rules-errorprone" % detektVersion.value,
    "io.gitlab.arturbosch.detekt" % "detekt-rules-exceptions" % detektVersion.value,
    "io.gitlab.arturbosch.detekt" % "detekt-rules-libraries" % detektVersion.value,
    "io.gitlab.arturbosch.detekt" % "detekt-rules-naming" % detektVersion.value,
    "io.gitlab.arturbosch.detekt" % "detekt-rules-performance" % detektVersion.value,
    "io.gitlab.arturbosch.detekt" % "detekt-rules-ruleauthors" % detektVersion.value,
    "io.gitlab.arturbosch.detekt" % "detekt-rules-style" % detektVersion.value,
    "io.gitlab.arturbosch.detekt" % "detekt-rules" % detektVersion.value,
    "io.gitlab.arturbosch.detekt" % "detekt-sample-extensions" % detektVersion.value,
    "io.gitlab.arturbosch.detekt" % "detekt-test-utils" % detektVersion.value,
    "io.gitlab.arturbosch.detekt" % "detekt-test" % detektVersion.value,
    "io.gitlab.arturbosch.detekt" % "detekt-tooling" % detektVersion.value,
    "io.gitlab.arturbosch.detekt" % "detekt-utils" % detektVersion.value,
    "org.scala-lang.modules" %% "scala-parallel-collections" % "0.2.0",
    "org.yaml" % "snakeyaml" % "1.26",
    "com.fasterxml.jackson.dataformat" % "jackson-dataformat-yaml" % "2.11.1",
    "net.ruippeixotog" %% "scala-scraper" % "3.1.1"
  )
}

enablePlugins(JavaAppPackaging)

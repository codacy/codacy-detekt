name := "codacy-detekt"

scalaVersion := "2.13.1"

lazy val detektVersion = Def.setting("1.10.0")

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
    "com.codacy" %% "codacy-engine-scala-seed" % "5.0.1",
    "org.scala-lang.modules" %% "scala-xml" % "1.3.0",
    "io.gitlab.arturbosch.detekt" % "detekt-core" % detektVersion.value,
    "io.gitlab.arturbosch.detekt" % "detekt-api" % detektVersion.value,
    "io.gitlab.arturbosch.detekt" % "detekt-rules" % detektVersion.value,
    "io.gitlab.arturbosch.detekt" % "detekt-cli" % detektVersion.value,
    "io.gitlab.arturbosch.detekt" % "detekt-generator" % detektVersion.value,
    "org.scala-lang.modules" %% "scala-parallel-collections" % "0.2.0",
    "org.yaml" % "snakeyaml" % "1.26",
    "com.fasterxml.jackson.dataformat" % "jackson-dataformat-yaml" % "2.11.1"
  )
}

enablePlugins(JavaAppPackaging)

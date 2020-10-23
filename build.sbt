name := "codacy-detekt"

scalaVersion := "2.13.3"

lazy val detektVersion = "1.14.2"

Compile / sourceGenerators += Def.task {
  val file = (Compile / sourceManaged).value / "codacy" / "detekt" / "Versions.scala"
  IO.write(file, s"""package codacy.detekt
                    |object Versions {
                    |  val detektVersion: String = "$detektVersion"
                    |}
                    |""".stripMargin)
  Seq(file)
}.taskValue

resolvers += Resolver.jcenterRepo

libraryDependencies ++= {
  Seq(
    "com.codacy" %% "codacy-engine-scala-seed" % "5.0.2",
    "org.scala-lang.modules" %% "scala-xml" % "1.3.0",
    "io.gitlab.arturbosch.detekt" % "detekt-core" % detektVersion,
    "io.gitlab.arturbosch.detekt" % "detekt-api" % detektVersion,
    "io.gitlab.arturbosch.detekt" % "detekt-rules" % detektVersion,
    "io.gitlab.arturbosch.detekt" % "detekt-cli" % detektVersion,
    "io.gitlab.arturbosch.detekt" % "detekt-generator" % detektVersion,
    "io.gitlab.arturbosch.detekt" % "detekt-sample-extensions" % detektVersion,
    "org.scala-lang.modules" %% "scala-parallel-collections" % "0.2.0",
    "org.yaml" % "snakeyaml" % "1.26",
    "com.fasterxml.jackson.dataformat" % "jackson-dataformat-yaml" % "2.11.1"
  )
}

enablePlugins(JavaAppPackaging)

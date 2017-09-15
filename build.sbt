import com.typesafe.sbt.packager.docker.{Cmd, ExecCmd}
import scala.util.parsing.json.JSON
import scala.io.Source

organization := "codacy"

name := "codacy-detekt"

version := "1.0.0-SNAPSHOT"

val languageVersion = "2.11.11"

scalaVersion := languageVersion

resolvers ++= Seq(
  "Arturbosch Detekt" at "https://dl.bintray.com/arturbosch/code-analysis/"
)

lazy val toolVersionKey = SettingKey[String]("The version of the underlying tool retrieved from patterns.json")

toolVersionKey := {
  val jsonFile = (resourceDirectory in Compile).value / "docs" / "patterns.json"
  val toolMap = JSON.parseFull(Source.fromFile(jsonFile).getLines().mkString)
    .getOrElse(throw new Exception("patterns.json is not a valid json"))
    .asInstanceOf[Map[String, String]]
  toolMap.getOrElse[String]("version", throw new Exception("Failed to retrieve 'version' from patterns.json"))
}

libraryDependencies ++= {
  val toolVersion = toolVersionKey.value
  Seq(
    "com.typesafe.play" %% "play-json" % "2.4.8",
    "com.codacy" %% "codacy-engine-scala-seed" % "2.7.7" withSources(),
    "org.scala-lang.modules" %% "scala-xml" % "1.0.6",
    "io.gitlab.arturbosch.detekt" % "detekt" % "1.0.0.RC4-3",
    "io.gitlab.arturbosch.detekt" % "detekt-cli" % "1.0.0.RC4-3",
    "io.gitlab.arturbosch.detekt" % "detekt-core" % "1.0.0.RC4-3",
    "org.yaml" % "snakeyaml" % "1.18",
    "com.fasterxml.jackson.dataformat" % "jackson-dataformat-yaml" % "2.8.4"
  )
}
enablePlugins(JavaAppPackaging)

enablePlugins(DockerPlugin)

version in Docker := "1.0"

val installAll =
  """apk update && apk add bash curl &&
    |rm -rf /tmp/* &&
    |rm -rf /var/cache/apk/*""".stripMargin.replaceAll(System.lineSeparator(), " ")

mappings in Universal <++= (resourceDirectory in Compile) map { (resourceDir: File) =>
  val src = resourceDir / "docs"
  val dest = "/docs"

  for {
    path <- (src ***).get
    if !path.isDirectory
  } yield path -> path.toString.replaceFirst(src.toString, dest)
}

val dockerUser = "docker"
val dockerGroup = "docker"

daemonUser in Docker := dockerUser

daemonGroup in Docker := dockerGroup

dockerBaseImage := "develar/java"

mainClass in Compile := Some("codacy.Engine")

dockerCommands := dockerCommands.value.flatMap {
  case cmd@Cmd("WORKDIR", _) => List(cmd,
    Cmd("RUN", installAll)
  )
  case cmd@(Cmd("ADD", "opt /opt")) => List(cmd,
    Cmd("RUN", "mv /opt/docker/docs /docs"),
    Cmd("RUN", s"adduser -u 2004 -D $dockerUser"),
    ExecCmd("RUN", Seq("chown", "-R", s"$dockerUser:$dockerGroup", "/docs"): _*)
  )
  case other => List(other)
}

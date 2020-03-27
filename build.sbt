import com.typesafe.sbt.packager.docker.Cmd
import sjsonnew._
import sjsonnew.BasicJsonProtocol._
import sjsonnew.support.scalajson.unsafe._

name := "codacy-detekt"

scalaVersion := "2.13.1"

lazy val toolVersionKey = settingKey[String]("The version of the underlying tool retrieved from patterns.json")

toolVersionKey := {
  case class Patterns(name: String, version: String)
  implicit val patternsIso: IsoLList[Patterns] =
    LList.isoCurried((p: Patterns) => ("name", p.name) :*: ("version", p.version) :*: LNil) {
      case (_, n) :*: (_, v) :*: LNil => Patterns(n, v)
    }

  val jsonFile = (resourceDirectory in Compile).value / "docs" / "patterns.json"
  val json = Parser.parseFromFile(jsonFile)
  val patterns = json.flatMap(Converter.fromJson[Patterns])
  patterns.get.version
}

resolvers += Resolver.jcenterRepo

libraryDependencies ++= {
  val toolVersion = toolVersionKey.value
  Seq(
    "com.codacy" %% "codacy-engine-scala-seed" % "4.0.3",
    "org.scala-lang.modules" %% "scala-xml" % "1.3.0",
    "io.gitlab.arturbosch.detekt" % "detekt-core" % toolVersion,
    "io.gitlab.arturbosch.detekt" % "detekt-api" % toolVersion,
    "io.gitlab.arturbosch.detekt" % "detekt-rules" % toolVersion,
    "io.gitlab.arturbosch.detekt" % "detekt-cli" % toolVersion,
    "io.gitlab.arturbosch.detekt" % "detekt-generator" % toolVersion,
    "org.scala-lang.modules" %% "scala-parallel-collections" % "0.2.0",
    "org.yaml" % "snakeyaml" % "1.26",
    "com.fasterxml.jackson.dataformat" % "jackson-dataformat-yaml" % "2.10.3"
  )
}

enablePlugins(AshScriptPlugin)

enablePlugins(DockerPlugin)

mappings in Universal ++= {
  (resourceDirectory in Compile) map { (resourceDir: File) =>
    val src = resourceDir / "docs"
    val dest = "/docs"

    for {
      path <- src.allPaths.get if !path.isDirectory
    } yield path -> path.toString.replaceFirst(src.toString, dest)
  }
}.value

val dockerUser = "docker"
val dockerGroup = "docker"

daemonUser in Docker := dockerUser

daemonGroup in Docker := dockerGroup

dockerBaseImage := "openjdk:8-jre-alpine"

mainClass in Compile := Some("codacy.Engine")

dockerCommands := dockerCommands.value.flatMap {
  case cmd @ Cmd("ADD", _) =>
    List(Cmd("RUN", s"adduser -u 2004 -D $dockerUser"), cmd, Cmd("RUN", "mv /opt/docker/docs /docs"))
  case other => List(other)
}

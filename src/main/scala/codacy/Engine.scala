package codacy

import com.codacy.tools.scala.seed.DockerEngine
import codacy.detekt.Detekt

object Engine extends DockerEngine(Detekt)()

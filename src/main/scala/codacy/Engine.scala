package codacy

import codacy.detekt.Detekt
import com.codacy.tools.scala.seed.DockerEngine

object Engine extends DockerEngine(Detekt)()

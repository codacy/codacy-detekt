package codacy

import codacy.dockerApi.DockerEngine
import codacy.detekt.Detekt

object Engine extends DockerEngine(Detekt)

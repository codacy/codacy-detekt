package codacy.detekt

import io.github.detekt.tooling.dsl.ProcessingSpecBuilder
import java.nio.file.Path

import io.gitlab.arturbosch.detekt.core.ProcessingSettings
import io.gitlab.arturbosch.detekt.api.Config

class ProcessingSettingsFactory {
  companion object {
    @JvmStatic
    fun create(paths: List<Path>, config: Config): ProcessingSettings {
      val processingSpec = ProcessingSpecBuilder()
      processingSpec.project { this.inputPaths = paths }
      return ProcessingSettings (processingSpec.build(), config)
    }
    @JvmStatic
    fun create(paths: List<Path>): ProcessingSettings {
      val processingSpec = ProcessingSpecBuilder()
      processingSpec.project { this.inputPaths = paths }
      return ProcessingSettings (processingSpec.build(), Config.empty)
    }
  }
}

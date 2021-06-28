package codacy.detekt

import io.github.detekt.tooling.api.spec.ProcessingSpec
import io.github.detekt.tooling.dsl.ProcessingSpecBuilder
import java.nio.file.Path

import io.gitlab.arturbosch.detekt.core.ProcessingSettings
import io.gitlab.arturbosch.detekt.api.Config

class ProcessingSettingsFactory {
  companion object {
    @JvmStatic
    fun create(paths: List<Path>, config: Config): ProcessingSettings {
      val processingSpec = ProcessingSpec {
        project {
          inputPaths = paths
        }
        config { useDefaultConfig = true }
        rules {
          autoCorrect = false
          activateAllRules = false
        }
      }
      return ProcessingSettings(processingSpec, config)
    }
    @JvmStatic
    fun create(paths: List<Path>): ProcessingSettings {
      return create(paths, Config.empty)
    }
  }
}

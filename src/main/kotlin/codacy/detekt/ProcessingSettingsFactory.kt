package codacy.detekt

import java.nio.file.Path

import io.github.detekt.tooling.api.spec.ProcessingSpec
import io.gitlab.arturbosch.detekt.core.ProcessingSettings
import io.gitlab.arturbosch.detekt.api.Config

class ProcessingSettingsFactory {
  companion object {
    @JvmStatic
    fun create(paths: List<Path>, config: Config): ProcessingSettings {
      val spec = ProcessingSpec {
        logging {
          outputChannel = System.out
          errorChannel = System.err
        }
        project {
          inputPaths = paths
        }
      }
      return ProcessingSettings(spec, config)
    }
    @JvmStatic
    fun create(paths: List<Path>): ProcessingSettings {
      return create(paths, Config.empty)
    }
  }
}

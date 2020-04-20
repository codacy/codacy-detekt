package codacy.detekt

import java.util.concurrent.ForkJoinPool
import java.nio.file.Path

import io.gitlab.arturbosch.detekt.core.ProcessingSettings
import io.gitlab.arturbosch.detekt.api.Config
import org.jetbrains.kotlin.config.JvmTarget
import org.jetbrains.kotlin.config.LanguageVersion

class ProcessingSettingsFactory {
  companion object {
    @JvmStatic
    fun create(paths: List<Path>, config: Config): ProcessingSettings {
      return ProcessingSettings (inputPaths = paths, config = config, outPrinter = System.out, errPrinter = System.err)
    }
    @JvmStatic
    fun create(paths: List<Path>): ProcessingSettings {
      return ProcessingSettings (inputPaths = paths, outPrinter = System.out, errPrinter = System.err)
    }
  }
}
package codacy.detekt

import io.gitlab.arturbosch.detekt.formatting.FormattingProvider
import io.gitlab.arturbosch.detekt.rules.providers._

object Providers {

  val list = List(
    new CommentSmellProvider,
    new ComplexityProvider,
    new EmptyCodeProvider,
    new ExceptionsProvider,
    new FormattingProvider,
    new NamingProvider,
    new PerformanceProvider,
    new PotentialBugProvider,
    new StyleGuideProvider
  )
}

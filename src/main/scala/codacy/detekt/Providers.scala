package codacy.detekt

import io.gitlab.arturbosch.detekt.formatting.FormattingProvider
import io.gitlab.arturbosch.detekt.rules.providers._

object Providers {

  val classes = List(
    classOf[CommentSmellProvider],
    classOf[ComplexityProvider],
    classOf[EmptyCodeProvider],
    classOf[ExceptionsProvider],
    classOf[FormattingProvider],
    classOf[NamingProvider],
    classOf[PerformanceProvider],
    classOf[PotentialBugProvider],
    classOf[StyleGuideProvider]
  )
}

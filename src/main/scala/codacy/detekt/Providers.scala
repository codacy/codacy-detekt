package codacy.detekt

import io.gitlab.arturbosch.detekt.formatting.FormattingProvider
import io.gitlab.arturbosch.detekt.rules.bugs.PotentialBugProvider
import io.gitlab.arturbosch.detekt.rules.complexity.ComplexityProvider
import io.gitlab.arturbosch.detekt.rules.coroutines.CoroutinesProvider
import io.gitlab.arturbosch.detekt.rules.documentation.CommentSmellProvider
import io.gitlab.arturbosch.detekt.rules.empty.EmptyCodeProvider
import io.gitlab.arturbosch.detekt.rules.exceptions.ExceptionsProvider
import io.gitlab.arturbosch.detekt.rules.naming.NamingProvider
import io.gitlab.arturbosch.detekt.rules.performance.PerformanceProvider
import io.gitlab.arturbosch.detekt.rules.style.StyleGuideProvider
import io.gitlab.arturbosch.detekt.libraries.RuleLibrariesProvider
import io.gitlab.arturbosch.detekt.authors.RuleAuthorsProvider
import io.gitlab.arturbosch.detekt.sample.extensions.SampleProvider


object Providers {

  val list = List(
    new CoroutinesProvider,
    new EmptyCodeProvider,
    new PotentialBugProvider,
    new CommentSmellProvider,
    new ComplexityProvider,
    new ExceptionsProvider,
    new FormattingProvider,
    new NamingProvider,
    new PerformanceProvider,
    new StyleGuideProvider,
    new RuleLibrariesProvider,
    new RuleAuthorsProvider,
    new SampleProvider
  )
}

# WildcardImport

Wildcard imports should be replaced with imports using fully qualified class names. This helps increase clarity of
which classes are imported and helps prevent naming conflicts.

Library updates can introduce naming clashes with your own classes which might result in compilation errors.

**NOTE:** This rule is effectively overridden by the `NoWildcardImports` formatting rule (a wrapped ktlint rule).
That rule will fail the check regardless of the whitelist configured here.
Therefore if whitelist is needed `NoWildcardImports` rule should be disabled.

## Noncompliant Code

```kotlin
import io.gitlab.arturbosch.detekt.*

class DetektElements {
    val element1 = DetektElement1()
    val element2 = DetektElement2()
}
```
## Compliant Code

```kotlin
import io.gitlab.arturbosch.detekt.DetektElement1
import io.gitlab.arturbosch.detekt.DetektElement2

class DetektElements {
    val element1 = DetektElement1()
    val element2 = DetektElement2()
}
```

[Source](https://arturbosch.github.io/detekt/style.html#wildcardimport)

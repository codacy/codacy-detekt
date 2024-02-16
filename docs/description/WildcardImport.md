# WildcardImport

Wildcard imports should be replaced with imports using fully qualified class names. This helps increase clarity of
which classes are imported and helps prevent naming conflicts.

Library updates can introduce naming clashes with your own classes which might result in compilation errors.

**NOTE**: This rule has a twin implementation NoWildcardImports in the formatting rule set (a wrapped KtLint rule).
When suppressing an issue of WildcardImport in the baseline file, make sure to suppress the corresponding NoWildcardImports issue.

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

[Source](https://detekt.dev/docs/rules/style#wildcardimport)

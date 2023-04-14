# ForbiddenImport

This rule allows to set a list of forbidden imports. This can be used to discourage the use of unstable, experimental
or deprecated APIs. Detekt will then report all imports that are forbidden.

## Noncompliant Code

```kotlin
import kotlin.jvm.JvmField
import kotlin.SinceKotlin
```

[Source](https://arturbosch.github.io/detekt/style.html#forbiddenimport)

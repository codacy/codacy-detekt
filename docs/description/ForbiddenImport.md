# ForbiddenImport

Reports all imports that are forbidden.

This rule allows to set a list of forbidden [imports].
This can be used to discourage the use of unstable, experimental or deprecated APIs.

## Noncompliant Code

```kotlin
import kotlin.jvm.JvmField
import kotlin.SinceKotlin
```

[Source](https://detekt.dev/docs/rules/style#forbiddenimport)

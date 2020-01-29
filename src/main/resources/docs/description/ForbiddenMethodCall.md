# ForbiddenMethodCall

This rule allows to set a list of forbidden methods. This can be used to discourage the use of unstable, experimental
or deprecated methods, especially for methods imported from external libraries.
Detekt will then report all methods invocation that are forbidden.

## Noncompliant Code

```kotlin
import java.lang.System
fun main() {
    System.gc()
}
```

[Source](https://arturbosch.github.io/detekt/style.html#forbiddenmethodcall)

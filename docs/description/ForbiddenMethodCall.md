# ForbiddenMethodCall

Reports all method or constructor invocations that are forbidden.

This rule allows to set a list of forbidden [methods] or constructors. This can be used to discourage the use
of unstable, experimental or deprecated methods, especially for methods imported from external libraries.

## Noncompliant Code

```kotlin
import java.lang.System
fun main() {
    System.gc()
    System::gc
}
```

[Source](https://detekt.dev/docs/rules/style#forbiddenmethodcall)

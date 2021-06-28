# IgnoredReturnValue

This rule warns on instances where a function, annotated with either `@CheckReturnValue` or `@CheckResult`,
returns a value but that value is not used in any way. The Kotlin compiler gives no warning for this scenario
normally so that's the rationale behind this rule.

fun returnsValue() = 42
fun returnsNoValue() {}

## Noncompliant Code

```kotlin
returnsValue()
```
## Compliant Code

```kotlin
if (42 == returnsValue()) {}
val x = returnsValue()
```

[Source](https://arturbosch.github.io/detekt/potential-bugs.html#ignoredreturnvalue)

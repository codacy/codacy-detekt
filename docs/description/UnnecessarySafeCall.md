# UnnecessarySafeCall

Reports unnecessary safe call operators (`.?`) that can be removed by the user.

## Noncompliant Code

```kotlin
val a: String = ""
val b = someValue?.length
```
## Compliant Code

```kotlin
val a: String? = null
val b = someValue?.length
```

[Source](https://arturbosch.github.io/detekt/potential-bugs.html#unnecessarysafecall)

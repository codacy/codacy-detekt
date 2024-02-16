# UnnecessarySafeCall

Reports unnecessary safe call operators (`?.`) that can be removed by the user.

## Noncompliant Code

```kotlin
val a: String = ""
val b = a?.length
```
## Compliant Code

```kotlin
val a: String? = null
val b = a?.length
```

[Source](https://detekt.github.io/detekt/potential-bugs.html#unnecessarysafecall)

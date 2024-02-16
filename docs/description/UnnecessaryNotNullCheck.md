# UnnecessaryNotNullCheck

Reports unnecessary not-null checks with `requireNotNull` or `checkNotNull` that can be removed by the user.

## Noncompliant Code

```kotlin
var string = "foo"
println(requireNotNull(string))
```
## Compliant Code

```kotlin
var string : String? = "foo"
println(requireNotNull(string))
```

[Source](https://detekt.github.io/detekt/potential-bugs.html#unnecessarynotnullcheck)

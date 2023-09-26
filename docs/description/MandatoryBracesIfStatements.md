# MandatoryBracesIfStatements

This rule detects multi-line `if` statements which do not have braces.
Adding braces would improve readability and avoid possible errors.

## Noncompliant Code

```kotlin
val i = 1
if (i > 0)
    println(i)
```
## Compliant Code

```kotlin
val x = if (condition) 5 else 4
```

[Source](https://detekt.github.io/detekt/style.html#mandatorybracesifstatements)

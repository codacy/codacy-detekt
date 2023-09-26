# AvoidReferentialEquality

Kotlin supports two types of equality: structural equality and referential equality. While there are
use cases for both, checking for referential equality for some types (such as `String` or `List`) is
likely not intentional and may cause unexpected results.

## Noncompliant Code

```kotlin
    val areEqual = "aString" === otherString
    val areNotEqual = "aString" !== otherString
```
## Compliant Code

```kotlin
    val areEqual = "aString" == otherString
    val areNotEqual = "aString" != otherString
```

[Source](https://detekt.github.io/detekt/potential-bugs.html#avoidreferentialequality)

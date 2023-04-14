# ElseCaseInsteadOfExhaustiveWhen

This rule reports `when` expressions that contain an `else` case even though they have an exhaustive set of cases.

This occurs when the subject of the `when` expression is either an enum class, sealed class or of type boolean.
Using `else` cases for these expressions can lead to unintended behavior when adding new enum types, sealed subtypes
or changing the nullability of a boolean, since this will be implicitly handled by the `else` case.

## Noncompliant Code

```kotlin
enum class Color {
    RED,
    GREEN,
    BLUE
}

when(c) {
    Color.RED -> {}
    Color.GREEN -> {}
    else -> {}
}
```
## Compliant Code

```kotlin
enum class Color {
    RED,
    GREEN,
    BLUE
}

when(c) {
    Color.RED -> {}
    Color.GREEN -> {}
    Color.BLUE -> {}
}
```

[Source](https://arturbosch.github.io/detekt/potential-bugs.html#elsecaseinsteadofexhaustivewhen)

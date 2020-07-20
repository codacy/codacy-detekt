# MissingWhenCase

Turn on this rule to flag `when` expressions that do not check that all cases are covered when the subject is an enum
or sealed class and the `when` expression is used as a statement.

When this happens it's unclear what was intended when an unhandled case is reached. It is better to be explicit and
either handle all cases or use a default `else` statement to cover the unhandled cases.

## Noncompliant Code

```kotlin
enum class Color {
    RED,
    GREEN,
    BLUE
}

fun whenOnEnumFail(c: Color) {
    when(c) {
        Color.BLUE -> {}
        Color.GREEN -> {}
    }
}
```
## Compliant Code

```kotlin
enum class Color {
    RED,
    GREEN,
    BLUE
}

fun whenOnEnumCompliant(c: Color) {
    when(c) {
        Color.BLUE -> {}
        Color.GREEN -> {}
        Color.RED -> {}
    }
}

fun whenOnEnumCompliant2(c: Color) {
    when(c) {
        Color.BLUE -> {}
        else -> {}
    }
}
```

[Source](https://arturbosch.github.io/detekt/potential-bugs.html#missingwhencase)

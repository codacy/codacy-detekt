# RedundantElseInWhen

Reports `when` expressions that contain a redundant `else` case. This occurs when it can be
verified that all cases are already covered when checking cases on an enum or sealed class.

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
        Color.RED -> {}
        else -> {}
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
        else -> {}
    }
}

fun whenOnEnumCompliant2(c: Color) {
    when(c) {
        Color.BLUE -> {}
        Color.GREEN -> {}
        Color.RED -> {}
    }
}
```

[Source](https://detekt.dev/docs/rules/potential-bugs#redundantelseinwhen)

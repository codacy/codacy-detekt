# EqualsOnSignatureLine

Requires that the equals sign, when used for an expression style function, is on the same line as the
rest of the function signature.

## Noncompliant Code

```kotlin
fun stuff(): Int
    = 5

fun <V> foo(): Int where V : Int
    = 5
```
## Compliant Code

```kotlin
fun stuff() = 5

fun stuff() =
    foo.bar()

fun <V> foo(): Int where V : Int = 5
```

[Source](https://detekt.github.io/detekt/style.html#equalsonsignatureline)

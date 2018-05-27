# ThrowsCount

Functions should have clear `throw` statements. Functions with many `throw` statements can be harder to read and lead
to confusion. Instead prefer to limit the amount of `throw` statements in a function.

## Noncompliant Code

```kotlin
fun foo(i: Int) {
    when (i) {
        1 -> throw IllegalArgumentException()
        2 -> throw IllegalArgumentException()
        3 -> throw IllegalArgumentException()
    }
}
```
## Compliant Code

```kotlin
fun foo(i: Int) {
    when (i) {
        1,2,3 -> throw IllegalArgumentException()
    }
}
```

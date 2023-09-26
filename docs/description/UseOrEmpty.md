# UseOrEmpty

This rule detects `?: emptyList()` that can be replaced with `orEmpty()` call.

## Noncompliant Code

```kotlin
fun test(x: List<Int>?, s: String?) {
    val a = x ?: emptyList()
    val b = s ?: ""
}
```
## Compliant Code

```kotlin
fun test(x: List<Int>?, s: String?) {
    val a = x.orEmpty()
    val b = s.orEmpty()
}
```

[Source](https://detekt.github.io/detekt/style.html#useorempty)

# UseIsNullOrEmpty

This rule detects null or empty checks that can be replaced with `isNullOrEmpty()` call.

## Noncompliant Code

```kotlin
fun foo(x: List<Int>?) {
    if (x == null || x.isEmpty()) return
}
fun bar(x: List<Int>?) {
    if (x == null || x.count() == 0) return
}
fun baz(x: List<Int>?) {
    if (x == null || x.size == 0) return
}
```
## Compliant Code

```kotlin
if (x.isNullOrEmpty()) return
```

[Source](https://detekt.github.io/detekt/style.html#useisnullorempty)

# UseIfEmptyOrIfBlank

This rule detects `isEmpty` or `isBlank` calls to assign a default value. They can be replaced with `ifEmpty` or
`ifBlank` calls.

## Noncompliant Code

```kotlin
fun test(list: List<Int>, s: String) {
    val a = if (list.isEmpty()) listOf(1) else list
    val b = if (list.isNotEmpty()) list else listOf(2)
    val c = if (s.isBlank()) "foo" else s
    val d = if (s.isNotBlank()) s else "bar"
}
```
## Compliant Code

```kotlin
fun test(list: List<Int>, s: String) {
    val a = list.ifEmpty { listOf(1) }
    val b = list.ifEmpty { listOf(2) }
    val c = s.ifBlank { "foo" }
    val d = s.ifBlank { "bar" }
}
```

[Source](https://detekt.github.io/detekt/style.html#useifemptyorifblank)

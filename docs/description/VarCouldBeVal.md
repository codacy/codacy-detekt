# VarCouldBeVal

Reports var declarations (locally-scoped variables) that could be val, as they are not re-assigned.
Val declarations are assign-once (read-only), which makes understanding the current state easier.

## Noncompliant Code

```kotlin
fun example() {
    var i = 1 // violation: this variable is never re-assigned
    val j = i + 1
}
```
## Compliant Code

```kotlin
fun example() {
    val i = 1
    val j = i + 1
}
```

[Source](https://arturbosch.github.io/detekt/style.html#varcouldbeval)

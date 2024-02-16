# RedundantExplicitType

Local properties do not need their type to be explicitly provided when the inferred type matches the explicit type.

## Noncompliant Code

```kotlin
fun function() {
    val x: String = "string"
}
```
## Compliant Code

```kotlin
fun function() {
    val x = "string"
}
```

[Source](https://detekt.github.io/detekt/style.html#redundantexplicittype)

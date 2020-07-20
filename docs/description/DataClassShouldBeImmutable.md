# DataClassShouldBeImmutable

This rule reports mutable properties inside data classes.

Data classes should mainly be used to store immutable data. This rule assumes that they should not contain any
mutable properties.

## Noncompliant Code

```kotlin
data class MutableDataClass(var i: Int) {
    var s: String? = null
}
```
## Compliant Code

```kotlin
data class ImmutableDataClass(
    val i: Int,
    val s: String?
)
```

[Source](https://arturbosch.github.io/detekt/style.html#dataclassshouldbeimmutable)

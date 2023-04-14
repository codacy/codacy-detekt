# DoubleMutabilityForCollection

Using `var` when declaring a mutable collection or value holder leads to double mutability.
Consider instead declaring your variable with `val` or switching your declaration to use an
immutable type.

By default, the rule triggers on standard mutable collections, however it can be configured
to trigger on other types of mutable value types, such as `MutableState` from Jetpack
Compose.

## Noncompliant Code

```kotlin
var myList = mutableListOf(1,2,3)
var mySet = mutableSetOf(1,2,3)
var myMap = mutableMapOf("answer" to 42)
```
## Compliant Code

```kotlin
// Use val
val myList = mutableListOf(1,2,3)
val mySet = mutableSetOf(1,2,3)
val myMap = mutableMapOf("answer" to 42)

// Use immutable types
var myList = listOf(1,2,3)
var mySet = setOf(1,2,3)
var myMap = mapOf("answer" to 42)
```

[Source](https://arturbosch.github.io/detekt/potential-bugs.html#doublemutabilityforcollection)

# UseEmptyCounterpart

Instantiation of an object's "empty" state should use the object's "empty" initializer for clarity purposes.

## Noncompliant Code

```kotlin
arrayOf()
listOf() // or listOfNotNull()
mapOf()
sequenceOf()
setOf()
```
## Compliant Code

```kotlin
emptyArray()
emptyList()
emptyMap()
emptySequence()
emptySet()
```

[Source](https://arturbosch.github.io/detekt/style.html#useemptycounterpart)

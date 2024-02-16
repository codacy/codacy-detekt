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

[Source](https://detekt.dev/docs/rules/style#useemptycounterpart)

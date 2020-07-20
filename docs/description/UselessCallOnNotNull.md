# UselessCallOnNotNull

The Kotlin stdlib provides some functions that are designed to operate on references that may be null. These
functions can also be called on non-nullable references or on collections or sequences that are known to be empty -
the calls are redundant in this case and can be removed or should be changed to a call that does not check whether
the value is null or not.

Rule adapted from Kotlin's IntelliJ plugin: https://github.com/JetBrains/kotlin/blob/f5d0a38629e7d2e7017ee645dc4d4bee60614e93/idea/src/org/jetbrains/kotlin/idea/inspections/collections/UselessCallOnNotNullInspection.kt

## Noncompliant Code

```kotlin
val testList = listOf("string").orEmpty()
val testList2 = listOf("string").orEmpty().map { _ }
val testString = ""?.isNullOrBlank()
```
## Compliant Code

```kotlin
val testList = listOf("string")
val testList2 = listOf("string").map { }
val testString = ""?.isBlank()
```

[Source](https://arturbosch.github.io/detekt/style.html#uselesscallonnotnull)

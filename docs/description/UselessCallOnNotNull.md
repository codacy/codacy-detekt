# UselessCallOnNotNull

The Kotlin stdlib provides some functions that are designed to operate on references that may be null. These
functions can also be called on non-nullable references or on collections or sequences that are known to be empty -
the calls are redundant in this case and can be removed or should be changed to a call that does not check whether
the value is null or not.

## Noncompliant Code

```kotlin
val testList = listOf("string").orEmpty()
val testList2 = listOf("string").orEmpty().map { _ }
val testList3 = listOfNotNull("string")
val testString = ""?.isNullOrBlank()
```
## Compliant Code

```kotlin
val testList = listOf("string")
val testList2 = listOf("string").map { }
val testList3 = listOf("string")
val testString = ""?.isBlank()
```

[Source](https://detekt.github.io/detekt/style.html#uselesscallonnotnull)

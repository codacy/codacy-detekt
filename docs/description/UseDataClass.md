# UseDataClass

Classes that simply hold data should be refactored into a `data class`. Data classes are specialized to hold data
and generate `hashCode`, `equals` and `toString` implementations as well.

Read more about [data classes](https://kotlinlang.org/docs/data-classes.html)

## Noncompliant Code

```kotlin
class DataClassCandidate(val i: Int) {
    val i2: Int = 0
}
```
## Compliant Code

```kotlin
data class DataClass(val i: Int, val i2: Int)

// classes with delegating interfaces are compliant
interface I
class B() : I
class A(val b: B) : I by b
```

[Source](https://detekt.dev/docs/rules/style#usedataclass)

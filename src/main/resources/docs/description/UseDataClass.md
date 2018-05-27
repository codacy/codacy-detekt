# UseDataClass

Classes that simply hold data should be refactored into a `data class`. Data classes are specialized to hold data
and generate `hashCode`, `equals` and `toString` implementations as well.

Read more about `data class`: https://kotlinlang.org/docs/reference/data-classes.html

## Noncompliant Code

```kotlin
class DataClassCandidate(val i: Int) {

    val i2: Int = 0
}
```
## Compliant Code

```kotlin
data class DataClass(val i: Int, val i2: Int)
```

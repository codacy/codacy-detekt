# ArrayPrimitive

Using Array<Primitive> leads to implicit boxing and performance hit. Prefer using Kotlin specialized Array
Instances.

As stated in the Kotlin [documentation](https://kotlinlang.org/docs/reference/basic-types.html#arrays) Kotlin has
specialized arrays to represent primitive types without boxing overhead, such as `IntArray`, `ByteArray` and so on.

## Noncompliant Code

```kotlin
fun function(array: Array<Int>) { }

fun returningFunction(): Array<Double> { }
```
## Compliant Code

```kotlin
fun function(array: IntArray) { }

fun returningFunction(): DoubleArray { }
```

[Source](https://arturbosch.github.io/detekt/performance.html#arrayprimitive)

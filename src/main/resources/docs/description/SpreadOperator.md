# SpreadOperator

In most cases using a spread operator causes a full copy of the array to be created before calling a method.
This has a very high performance penalty. Benchmarks showing this performance penalty can be seen here:
https://sites.google.com/a/athaydes.com/renato-athaydes/posts/kotlinshiddencosts-benchmarks

The Kotlin compiler since v1.1.60 has an optimization that skips the array copy when an array constructor
function is used to create the arguments that are passed to the vararg parameter. When type resolution is enabled in
detekt this case will not be flagged by the rule since it doesn't suffer the performance penalty of an array copy.

## Noncompliant Code

```kotlin
val strs = arrayOf("value one", "value two")
val foo = bar(*strs)

fun bar(vararg strs: String) {
    strs.forEach { println(it) }
}
```
## Compliant Code

```kotlin
// array copy skipped in this case since Kotlin 1.1.60
val foo = bar(*arrayOf("value one", "value two"))

// array not passed so no array copy is required
val foo2 = bar("value one", "value two")

fun bar(vararg strs: String) {
    strs.forEach { println(it) }
}
```

[Source](https://arturbosch.github.io/detekt/performance.html#spreadoperator)

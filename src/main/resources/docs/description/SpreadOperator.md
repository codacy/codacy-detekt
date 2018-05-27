# SpreadOperator

Using a spread operator causes a full copy of the array to be created before calling a method.
This has a very high performance penalty.
Benchmarks showing this performance penalty can be seen here:
https://sites.google.com/a/athaydes.com/renato-athaydes/posts/kotlinshiddencosts-benchmarks

## Noncompliant Code

```kotlin
fun foo(strs: Array<String>) {
    bar(*strs)
}

fun bar(vararg strs: String) {
    strs.forEach { println(it) }
}
```

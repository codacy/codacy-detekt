# ForEachOnRange

Using the forEach method on ranges has a heavy performance cost. Prefer using simple for loops.

Benchmarks have shown that using forEach on a range can have a huge performance cost in comparison to
simple for loops. Hence, in most contexts, a simple for loop should be used instead.
See more details here: https://sites.google.com/a/athaydes.com/renato-athaydes/posts/kotlinshiddencosts-benchmarks
To solve this CodeSmell, the forEach usage should be replaced by a for loop.

## Noncompliant Code

```kotlin
(1..10).forEach {
    println(it)
}
(1 until 10).forEach {
    println(it)
}
(10 downTo 1).forEach {
    println(it)
}
```
## Compliant Code

```kotlin
for (i in 1..10) {
    println(i)
}
```

[Source](https://detekt.dev/docs/rules/performance#foreachonrange)

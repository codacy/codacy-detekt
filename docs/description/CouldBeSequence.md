# CouldBeSequence

Long chains of collection operations will have a performance penalty due to a new list being created for each call. Consider using sequences instead. Read more about this in the [documentation](https://kotlinlang.org/docs/sequences.html)

## Noncompliant Code

```kotlin
listOf(1, 2, 3, 4).map { it*2 }.filter { it < 4 }.map { it*it }
```
## Compliant Code

```kotlin
listOf(1, 2, 3, 4).asSequence().map { it*2 }.filter { it < 4 }.map { it*it }.toList()

listOf(1, 2, 3, 4).map { it*2 }
```

[Source](https://detekt.github.io/detekt/performance.html#couldbesequence)

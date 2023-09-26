# UnnecessaryFilter

Unnecessary filters add complexity to the code and accomplish nothing. They should be removed.

## Noncompliant Code

```kotlin
val x = listOf(1, 2, 3)
    .filter { it > 1 }
    .count()

val x = listOf(1, 2, 3)
    .filter { it > 1 }
    .isEmpty()
```
## Compliant Code

```kotlin
val x = listOf(1, 2, 3)
    .count { it > 2 }
}

val x = listOf(1, 2, 3)
    .none { it > 1 }
```

[Source](https://detekt.github.io/detekt/style.html#unnecessaryfilter)

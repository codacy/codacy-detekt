# UseAnyOrNoneInsteadOfFind

Turn on this rule to flag `find` calls for null check that can be replaced with a `any` or `none` call.

## Noncompliant Code

```kotlin
listOf(1, 2, 3).find { it == 4 } != null
listOf(1, 2, 3).find { it == 4 } == null
```
## Compliant Code

```kotlin
listOf(1, 2, 3).any { it == 4 }
listOf(1, 2, 3).none { it == 4 }
```

[Source](https://arturbosch.github.io/detekt/style.html#useanyornoneinsteadoffind)

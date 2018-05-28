# ModifierOrder

This rule reports cases in the code where modifiers are not in the correct order. The default modifier order is
taken from: http://kotlinlang.org/docs/reference/coding-conventions.html#modifiers

## Noncompliant Code

```kotlin
lateinit internal private val str: String
```
## Compliant Code

```kotlin
private internal lateinit val str: String
```

[Source](https://arturbosch.github.io/detekt/style.html#modifierorder)

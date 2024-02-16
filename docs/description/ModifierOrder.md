# ModifierOrder

This rule reports cases in the code where modifiers are not in the correct order. The default modifier order is
taken from: [Modifiers order](https://kotlinlang.org/docs/coding-conventions.html#modifiers-order)

## Noncompliant Code

```kotlin
lateinit internal val str: String
```
## Compliant Code

```kotlin
internal lateinit val str: String
```

[Source](https://detekt.dev/docs/rules/style#modifierorder)

# NullableBooleanCheck

Detects nullable boolean checks which use an elvis expression `?:` rather than equals `==`.

Per the [Kotlin coding conventions](https://kotlinlang.org/docs/coding-conventions.html#nullable-boolean-values-in-conditions)
converting a nullable boolean property to non-null should be done via `!= false` or `== true`
rather than `?: true` or `?: false` (respectively).

## Noncompliant Code

```kotlin
value ?: true
value ?: false
```
## Compliant Code

```kotlin
value != false
value == true
```

[Source](https://arturbosch.github.io/detekt/style.html#nullablebooleancheck)

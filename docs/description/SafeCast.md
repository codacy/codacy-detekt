# SafeCast

This rule inspects casts and reports casts which could be replaced with safe casts instead.

## Noncompliant Code

```kotlin
fun numberMagic(number: Number) {
    val i = if (number is Int) number else null
    // ...
}
```
## Compliant Code

```kotlin
fun numberMagic(number: Number) {
    val i = number as? Int
    // ...
}
```

[Source](https://detekt.dev/docs/rules/style#safecast)

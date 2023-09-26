# UnnecessaryTemporaryInstantiation

Avoid temporary objects when converting primitive types to String. This has a performance penalty when compared
to using primitive types directly.
To solve this issue, remove the wrapping type.

## Noncompliant Code

```kotlin
val i = Integer(1).toString() // temporary Integer instantiation just for the conversion
```
## Compliant Code

```kotlin
val i = Integer.toString(1)
```

[Source](https://detekt.github.io/detekt/performance.html#unnecessarytemporaryinstantiation)

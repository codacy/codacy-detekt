# ForbiddenAnnotation

This rule allows to set a list of forbidden annotations. This can be used to discourage the use
of language annotations which do not require explicit import.

## Noncompliant Code

```kotlin
@SuppressWarnings("unused")
class SomeClass()
```
## Compliant Code

```kotlin
@Suppress("unused")
class SomeClass()
```

[Source](https://arturbosch.github.io/detekt/style.html#forbiddenannotation)

# ForbiddenVoid

This rule detects usages of `Void` and reports them as forbidden.
The Kotlin type `Unit` should be used instead. This type corresponds to the `Void` class in Java
and has only one value - the `Unit` object.

## Noncompliant Code

```kotlin
runnable: () -> Void
var aVoid: Void? = null
```
## Compliant Code

```kotlin
runnable: () -> Unit
Void::class
```

[Source](https://arturbosch.github.io/detekt/style.html#forbiddenvoid)

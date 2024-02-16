# UseArrayLiteralsInAnnotations

This rule detects annotations which use the arrayOf(...) syntax instead of the array literal [...] syntax.
The latter should be preferred as it is more readable.

## Noncompliant Code

```kotlin
@PositiveCase(arrayOf("..."))
```
## Compliant Code

```kotlin
@NegativeCase(["..."])
```

[Source](https://detekt.dev/docs/rules/style#usearrayliteralsinannotations)

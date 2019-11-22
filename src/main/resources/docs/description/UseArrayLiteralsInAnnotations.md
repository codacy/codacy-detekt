# UseArrayLiteralsInAnnotations

This rule detects annotations which use the arrayOf(...) syntax instead of the array literal [...] syntax.
The latter should be preferred as it is more readable.

## Noncompliant Code

```kotlin
&#064;PositiveCase(arrayOf("..."))
```
## Compliant Code

```kotlin
&#064;NegativeCase(["..."])
```

[Source](https://arturbosch.github.io/detekt/style.html#usearrayliteralsinannotations)

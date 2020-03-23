# ForbiddenComment

This rule allows to set a list of comments which are forbidden in the codebase and should only be used during
development. Offending code comments will then be reported.

## Noncompliant Code

```kotlin
val a = "" // TODO: remove please
// FIXME: this is a hack
fun foo() { }
// STOPSHIP:
```

[Source](https://arturbosch.github.io/detekt/style.html#forbiddencomment)

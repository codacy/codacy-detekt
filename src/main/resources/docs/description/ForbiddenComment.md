# ForbiddenComment

This rule allows to set a list of comments which are forbidden in the codebase and should only be used during
development. Offending code comments will then be reported.

## Noncompliant Code

```kotlin
// TODO:,FIXME:,STOPSHIP:
fun foo() { }
```

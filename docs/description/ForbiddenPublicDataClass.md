# ForbiddenPublicDataClass

The data classes are bad for the binary compatibility in public APIs. Avoid to use it.

This rule is aimed to library maintainers. If you are developing a final application you don't need to care about
this issue.

More info: https://jakewharton.com/public-api-challenges-in-kotlin/

## Noncompliant Code

```kotlin
data class C(val a: String) // violation: public data class
```
## Compliant Code

```kotlin
internal data class C(val a: String)
```

[Source](https://arturbosch.github.io/detekt/style.html#forbiddenpublicdataclass)

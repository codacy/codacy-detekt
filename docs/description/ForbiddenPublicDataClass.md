# ForbiddenPublicDataClass

Data classes are bad for binary compatibility in public APIs. Avoid using them.

This rule is aimed at library maintainers. If you are developing a final application you can ignore this issue.

More info: [Public API challenges in Kotlin](https://jakewharton.com/public-api-challenges-in-kotlin/)

## Noncompliant Code

```kotlin
data class C(val a: String) // violation: public data class
```
## Compliant Code

```kotlin
internal data class C(val a: String)
```

[Source](https://detekt.dev/docs/rules/libraries#forbiddenpublicdataclass)

# FunctionTypeReferenceSpacing

Consistent spacing in the type reference before a function.

## Noncompliant Code

```kotlin
fun String .foo() = "some-result"
fun String
    .foo() = "some-result"
fun String? .foo() = "some-result"
fun String?
    .foo() = "some-result"
```
## Compliant Code

```kotlin
fun String.foo() = "some-result"
```

[Source](https://detekt.dev/docs/rules/formatting#functiontypereferencespacing)

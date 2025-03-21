# ParameterListSpacing

Consistent spacing inside the parameter list.

## Noncompliant Code

```kotlin
fun foo( a : Any ) = "some-result"
fun foo(
) = "some-result"
```
## Compliant Code

```kotlin
fun foo(a: Any ) = "some-result"
fun foo() = "some-result"
```

[Source](https://detekt.dev/docs/rules/formatting#parameterlistspacing)

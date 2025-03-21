# TypeParameterListSpacing

Spacing after a type parameter list in function and class declarations.

## Noncompliant Code

```kotlin
fun<T> foo1(t: T) = "some-result"
fun <T>foo2(t: T) = "some-result"
fun<T>foo3(t: T) = "some-result"
```
## Compliant Code

```kotlin
fun <T> foo1(t: T) = "some-result"
fun <T> foo2(t: T) = "some-result"
fun <T> foo3(t: T) = "some-result"
```

[Source](https://detekt.dev/docs/rules/formatting#typeparameterlistspacing)

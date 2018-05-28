# OptionalUnit

It is not necessary to define a return type of `Unit` on functions. This rule detects and reports instances where
the `Unit` return type is specified on functions.

## Noncompliant Code

```kotlin
fun foo(): Unit { }
```
## Compliant Code

```kotlin
fun foo() { }
```

[Source](https://arturbosch.github.io/detekt/style.html#optionalunit)

# FunctionName

Enforce naming of function.

## Noncompliant Code

```kotlin
@Test
fun `Some name`() {}

@Test
fun do_something() {}
```
## Compliant Code

```kotlin
fun foo() {}
fun fooBar() {}
```

[Source](https://detekt.dev/docs/rules/formatting#functionname)

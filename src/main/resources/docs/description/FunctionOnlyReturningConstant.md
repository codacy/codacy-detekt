# FunctionOnlyReturningConstant

A function that only returns a single constant can be misleading. Instead prefer to define the constant directly
as a `const val`.

## Noncompliant Code

```kotlin
fun functionReturningConstantString() = "1"
```
## Compliant Code

```kotlin
const val constantString = "1"
```

[Source](https://arturbosch.github.io/detekt/style.html#functiononlyreturningconstant)

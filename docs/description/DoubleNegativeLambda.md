# DoubleNegativeLambda

Detects negation in lambda blocks where the function name is also in the negative (like `takeUnless`).
A double negative is harder to read than a positive. In particular, if there are multiple conditions with `&&` etc. inside
the lambda, then the reader may need to unpack these using DeMorgan's laws. Consider rewriting the lambda to use a positive version
of the function (like `takeIf`).

## Noncompliant Code

```kotlin
fun Int.evenOrNull() = takeUnless { it % 2 != 0 }
```
## Compliant Code

```kotlin
fun Int.evenOrNull() = takeIf { it % 2 == 0 }
```

[Source](https://arturbosch.github.io/detekt/style.html#doublenegativelambda)

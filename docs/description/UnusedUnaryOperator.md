# UnusedUnaryOperator

Detects unused unary operators.

## Noncompliant Code

```kotlin
val x = 1 + 2
    + 3 + 4
println(x) // 3
```
## Compliant Code

```kotlin
val x = 1 + 2 + 3 + 4
println(x) // 10
```

[Source](https://detekt.github.io/detekt/potential-bugs.html#unusedunaryoperator)

# UnnecessaryNotNullOperator

Reports unnecessary not-null operator usage (!!) that can be removed by the user.

## Noncompliant Code

```kotlin
val a = 1
val b = a!!
```
## Compliant Code

```kotlin
val a = 1
val b = a
```

[Source](https://arturbosch.github.io/detekt/potential-bugs.html#unnecessarynotnulloperator)

# SpacingAroundRangeOperator

Consistent spacing around range operators.

## Noncompliant Code

```kotlin
val foo1 = (1.. 12 step 2).last
val foo2 = (1 .. 12 step 2).last
val foo3 = (1 ..12 step 2).last
```
## Compliant Code

```kotlin
val foo1 = (1..12 step 2).last
val foo2 = (1..12 step 2).last
val foo3 = (1..12 step 2).last
```

[Source](https://detekt.dev/docs/rules/formatting#spacingaroundrangeoperator)

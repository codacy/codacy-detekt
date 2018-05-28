# UntilInsteadOfRangeTo

Reports calls to '..' operator instead of calls to 'until'.
'until' is applicable in cases where the upper range value is described as
some value subtracted by 1. 'until' helps to prevent off-by-one errors.

## Noncompliant Code

```kotlin
for (i in 0 .. 10 - 1) {}
val range = 0 .. 10 - 1
```
## Compliant Code

```kotlin
for (i in 0 until 10) {}
val range = 0 until 10
```

[Source](https://arturbosch.github.io/detekt/style.html#untilinsteadofrangeto)

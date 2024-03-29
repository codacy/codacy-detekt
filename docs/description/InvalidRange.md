# InvalidRange

Reports ranges which are empty.
This might be a bug if it is used for instance as a loop condition. This loop will never be triggered then.
This might be due to invalid ranges like (10..9) which will cause the loop to never be entered.

## Noncompliant Code

```kotlin
for (i in 2..1) {}
for (i in 1 downTo 2) {}

val range1 = 2 until 1
val range2 = 2 until 2
```
## Compliant Code

```kotlin
for (i in 2..2) {}
for (i in 2 downTo 2) {}

val range = 2 until 3
```

[Source](https://detekt.dev/docs/rules/potential-bugs#invalidrange)

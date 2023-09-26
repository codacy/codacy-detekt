# UnnecessaryPartOfBinaryExpression

Unnecessary binary expression add complexity to the code and accomplish nothing. They should be removed.
The rule works with all binary expression included if and when condition. The rule also works with all predicates.
The rule verify binary expression only in case when the expression use only one type of the following
operators || or &&.

## Noncompliant Code

```kotlin
val foo = true
val bar = true

if (foo || bar || foo) {
}
```
## Compliant Code

```kotlin
val foo = true
if (foo) {
}
```

[Source](https://detekt.github.io/detekt/performance.html#unnecessarypartofbinaryexpression)

# NamedArguments

Reports function invocations which have more parameters than a certain threshold and are all not named.

## Noncompliant Code

```kotlin
fun sum(a: Int, b: Int, c: Int, d: Int) {
}
sum(1, 2, 3, 4)
```
## Compliant Code

```kotlin
fun sum(a: Int, b: Int, c: Int, d: Int) {
}
sum(a = 1, b = 2, c = 3, d = 4)
```

[Source](https://arturbosch.github.io/detekt/complexity.html#namedarguments)

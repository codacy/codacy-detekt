# UseCheckOrError

Kotlin provides a much more concise way to check invariants as well as pre- and post conditions than to manually throw
an IllegalStateException.

## Noncompliant Code

```kotlin
if (value == null) throw new IllegalStateException("value should not be null")
if (value < 0) throw new IllegalStateException("value is $value but should be at least 0")
when(a) {
1 -> doSomething()
else -> throw IllegalStateException("Unexpected value")
}
```
## Compliant Code

```kotlin
checkNotNull(value) {"value should not be null"}
check(value >= 0) { "value is $value but should be at least 0" }
when(a) {
1 -> doSomething()
else -> error("Unexpected value")
}
```

[Source](https://arturbosch.github.io/detekt/style.html#usecheckorerror)

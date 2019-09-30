# UseRequire

Kotlin provides a much more concise way to check preconditions than to manually throw an
IllegalArgumentException.

## Noncompliant Code

```kotlin
if (value == null) throw new IllegalArgumentException("value should not be null")
if (value < 0) throw new IllegalArgumentException("value is $value but should be at least 0")
```
## Compliant Code

```kotlin
requireNotNull(value) {"value should not be null"}
require(value >= 0) { "value is $value but should be at least 0" }
```

[Source](https://arturbosch.github.io/detekt/style.html#userequire)
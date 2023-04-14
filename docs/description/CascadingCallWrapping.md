# CascadingCallWrapping

Requires that all chained calls are placed on a new line if a preceding one is.

## Noncompliant Code

```kotlin
foo()
.bar().baz()
```
## Compliant Code

```kotlin
foo().bar().baz()

foo()
.bar()
.baz()
```

[Source](https://arturbosch.github.io/detekt/style.html#cascadingcallwrapping)

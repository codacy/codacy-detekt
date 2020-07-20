# MapGetWithNotNullAssertionOperator

Reports calls of the map access methods `map[]` or `map.get()` with a not-null assertion operator `!!`.
This may result in a NullPointerException.
Preferred access methods are `map[]` without `!!`, `map.getValue()`, `map.getOrDefault()` or `map.getOrElse()`.

Based on an IntelliJ IDEA inspection MapGetWithNotNullAssertionOperatorInspection.

## Noncompliant Code

```kotlin
val map = emptyMap<String, String>()
map["key"]!!

val map = emptyMap<String, String>()
map.get("key")!!
```
## Compliant Code

```kotlin
val map = emptyMap<String, String>()
map["key"]

val map = emptyMap<String, String>()
map.getValue("key")

val map = emptyMap<String, String>()
map.getOrDefault("key", "")

val map = emptyMap<String, String>()
map.getOrElse("key", { "" })
```

[Source](https://arturbosch.github.io/detekt/potential-bugs.html#mapgetwithnotnullassertionoperator)

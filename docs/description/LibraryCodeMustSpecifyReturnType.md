# LibraryCodeMustSpecifyReturnType

Library functions/properties should have an explicit return type.
Inferred return type can easily be changed by mistake which may lead to breaking changes.

## Noncompliant Code

```kotlin
// code from a library
val strs = listOf("foo, bar")
fun bar() = 5
class Parser {
    fun parse() = ...
}
```
## Compliant Code

```kotlin
// code from a library
val strs: List<String> = listOf("foo, bar")
fun bar(): Int = 5

class Parser {
    fun parse(): ParsingResult = ...
}
```

[Source](https://arturbosch.github.io/detekt/style.html#librarycodemustspecifyreturntype)

# LibraryCodeMustSpecifyReturnType

Functions/properties exposed as public APIs of a library should have an explicit return type.
Inferred return type can easily be changed by mistake which may lead to breaking changes.

See also: [Kotlin 1.4 Explicit API](https://kotlinlang.org/docs/reference/whatsnew14.html#explicit-api-mode-for-library-authors)

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

# DeprecatedBlockTag

This rule reports use of the `@deprecated` block tag in KDoc comments. Deprecation must be specified using a
`@Deprecated` annotation as adding a `@deprecated` block tag in KDoc comments
[has no effect and is not supported](https://kotlinlang.org/docs/kotlin-doc.html#suppress). The `@Deprecated`
annotation constructor has dedicated fields for a message and a type (warning, error, etc.). You can also use the
`@ReplaceWith` annotation to specify how to solve the deprecation automatically via the IDE.

## Noncompliant Code

```kotlin
/**
* This function prints a message followed by a new line.
*
* @deprecated Useless, the Kotlin standard library can already do this. Replace with println.
*/
fun printThenNewline(what: String) {
    // ...
}
```
## Compliant Code

```kotlin
/**
* This function prints a message followed by a new line.
*/
@Deprecated("Useless, the Kotlin standard library can already do this.")
@ReplaceWith("println(what)")
fun printThenNewline(what: String) {
    // ...
}
```

[Source](https://arturbosch.github.io/detekt/comments.html#deprecatedblocktag)

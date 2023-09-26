# CollapsibleIfStatements

This rule detects `if` statements which can be collapsed. This can reduce nesting and help improve readability.

However, carefully consider whether merging the if statements actually improves readability, as collapsing the
statements may hide some edge cases from the reader.

## Noncompliant Code

```kotlin
val i = 1
if (i > 0) {
    if (i < 5) {
        println(i)
    }
}
```
## Compliant Code

```kotlin
val i = 1
if (i > 0 && i < 5) {
    println(i)
}
```

[Source](https://detekt.github.io/detekt/style.html#collapsibleifstatements)

# CollapsibleIfStatements

This rule detects `if` statements which can be collapsed. This can reduce nesting and help improve readability.

However it should be carefully considered if merging the if statements actually does improve readability or if it
hides some edge-cases from the reader.

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

[Source](https://arturbosch.github.io/detekt/style.html#collapsibleifstatements)

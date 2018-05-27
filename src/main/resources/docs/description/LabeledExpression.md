# LabeledExpression

This rule reports labeled expressions. Expressions with labels generally increase complexity and worsen the
maintainability of the code. Refactor the violating code to not use labels instead.

## Noncompliant Code

```kotlin
val range = listOf<String>("foo", "bar")
loop@ for (r in range) {
    if (r == "bar") break@loop
    println(r)
}
```
## Compliant Code

```kotlin
val range = listOf<String>("foo", "bar")
for (r in range) {
    if (r == "bar") break
    println(r)
}
```

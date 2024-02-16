# ExpressionBodySyntax

Functions which only contain a `return` statement can be collapsed to an expression body. This shortens and
cleans up the code.

## Noncompliant Code

```kotlin
fun stuff(): Int {
    return 5
}
```
## Compliant Code

```kotlin
fun stuff() = 5

fun stuff() {
    return
        moreStuff()
            .getStuff()
            .stuffStuff()
}
```

[Source](https://detekt.dev/docs/rules/style#expressionbodysyntax)

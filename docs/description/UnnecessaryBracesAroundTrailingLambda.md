# UnnecessaryBracesAroundTrailingLambda

In Kotlin functions the last lambda parameter of a function is a function then a lambda expression passed as the
corresponding argument can be placed outside the parentheses.
see [Passing trailing lambdas](https://kotlinlang.org/docs/lambdas.html#passing-trailing-lambdas).
Prefer the usage of trailing lambda.

## Noncompliant Code

```kotlin
fun test() {
    repeat(10, {
        println(it)
    })
}
```
## Compliant Code

```kotlin
fun test() {
    repeat(10) {
        println(it)
    }
}
```

[Source](https://detekt.dev/docs/rules/style#unnecessarybracesaroundtrailinglambda)

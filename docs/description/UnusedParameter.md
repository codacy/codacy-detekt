# UnusedParameter

An unused parameter can be removed to simplify the signature of the function.

## Noncompliant Code

```kotlin
fun foo(unused: String) {
println()
}
```
## Compliant Code

```kotlin
fun foo(used: String) {
println(used)
}
```

[Source](https://detekt.dev/docs/rules/style#unusedparameter)

# RedundantSuspendModifier

`suspend` modifier should only be used where needed, otherwise the function can only be used from other suspending
functions. This needlessly restricts use of the function and should be avoided by removing the `suspend` modifier
where it's not needed.

## Noncompliant Code

```kotlin
suspend fun normalFunction() {
    println("string")
}
```
## Compliant Code

```kotlin
fun normalFunction() {
    println("string")
}
```

[Source](https://detekt.dev/docs/rules/coroutines#redundantsuspendmodifier)

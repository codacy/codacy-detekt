# ThrowingExceptionInMain

This rule reports all exceptions that are thrown in a `main` method.
An exception should only be thrown if it can be handled by a "higher" function.

## Noncompliant Code

```kotlin
fun main(args: Array<String>) {
    // ...
    throw IOException() // exception should not be thrown here
}
```

[Source](https://detekt.github.io/detekt/exceptions.html#throwingexceptioninmain)

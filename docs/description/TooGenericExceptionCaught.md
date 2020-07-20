# TooGenericExceptionCaught

This rule reports `catch` blocks for exceptions that have a type that is too generic.
It should be preferred to catch specific exceptions to the case that is currently handled. If the scope of the caught
exception is too broad it can lead to unintended exceptions being caught.

## Noncompliant Code

```kotlin
fun foo() {
    try {
        // ... do some I/O
    } catch(e: Exception) { } // too generic exception caught here
}
```
## Compliant Code

```kotlin
fun foo() {
    try {
        // ... do some I/O
    } catch(e: IOException) { }
}
```

[Source](https://arturbosch.github.io/detekt/exceptions.html#toogenericexceptioncaught)

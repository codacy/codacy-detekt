# RethrowCaughtException

This rule reports all exceptions that are caught and then later re-thrown without modification.
It ignores caught exceptions that are rethrown if there is work done before that.

## Noncompliant Code

```kotlin
fun foo() {
    try {
        // ...
    } catch (e: IOException) {
        throw e
    }
    try {
        // ...
    } catch (e: IOException) {
        print(e.message)
        throw e
    }
}
```
## Compliant Code

```kotlin
fun foo() {
    try {
        // ...
    } catch (e: IOException) {
        throw MyException(e)
    }
    try {
        // ...
    } catch (e: IOException) {
        print(e)
        throw e
    }
}
```

[Source](https://arturbosch.github.io/detekt/exceptions.html#rethrowcaughtexception)

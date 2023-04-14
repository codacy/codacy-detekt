# RethrowCaughtException

This rule reports all exceptions that are caught and then later re-thrown without modification.
It ignores cases:
1. When caught exceptions that are rethrown if there is work done before that.
2. When there are more than one catch in try block and at least one of them has some work.

## Noncompliant Code

```kotlin
fun foo() {
    try {
        // ...
    } catch (e: IOException) {
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
    try {
        // ...
    } catch (e: IOException) {
        print(e.message)
        throw e
    }

    try {
        // ...
    } catch (e: IOException) {
        throw e
    } catch (e: Exception) {
        print(e.message)
    }
}
```

[Source](https://arturbosch.github.io/detekt/exceptions.html#rethrowcaughtexception)

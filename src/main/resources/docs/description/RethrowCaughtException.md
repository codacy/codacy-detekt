# RethrowCaughtException

This rule reports all exceptions that are caught and then later re-thrown without modification.

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
}
```

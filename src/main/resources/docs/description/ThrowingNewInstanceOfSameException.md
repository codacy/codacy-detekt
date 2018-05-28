# ThrowingNewInstanceOfSameException

Exceptions should not be wrapped inside the same exception type and then rethrown. Prefer wrapping exceptions in more
meaningful exception types.

## Noncompliant Code

```kotlin
fun foo() {
    try {
        // ...
    } catch (e: IllegalStateException) {
        throw IllegalStateException(e) // rethrows the same exception
    }
}
```
## Compliant Code

```kotlin
fun foo() {
    try {
        // ...
    } catch (e: IllegalStateException) {
        throw MyException(e)
    }
}
```

[Source](https://arturbosch.github.io/detekt/exceptions.html#throwingnewinstanceofsameexception)

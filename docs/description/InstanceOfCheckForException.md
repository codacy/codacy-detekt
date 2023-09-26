# InstanceOfCheckForException

This rule reports `catch` blocks which check for the type of exception via `is` checks or casts.
Instead of catching generic exception types and then checking for specific exception types the code should
use multiple catch blocks. These catch blocks should then catch the specific exceptions.

## Noncompliant Code

```kotlin
fun foo() {
    try {
        // ... do some I/O
    } catch(e: IOException) {
        if (e is MyException || (e as MyException) != null) { }
    }
}
```
## Compliant Code

```kotlin
fun foo() {
    try {
        // ... do some I/O
    } catch(e: MyException) {
    } catch(e: IOException) {
    }
}
```

[Source](https://detekt.github.io/detekt/exceptions.html#instanceofcheckforexception)

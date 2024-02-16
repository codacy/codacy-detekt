# ThrowingExceptionFromFinally

This rule reports all cases where exceptions are thrown from a `finally` block. Throwing exceptions from a `finally`
block should be avoided as it can lead to confusion and discarded exceptions.

## Noncompliant Code

```kotlin
fun foo() {
    try {
        // ...
    } finally {
        throw IOException()
    }
}
```

[Source](https://detekt.dev/docs/rules/exceptions#throwingexceptionfromfinally)

# ThrowingExceptionsWithoutMessageOrCause

This rule reports all exceptions which are thrown without arguments or further description.
Exceptions should always call one of the constructor overloads to provide a message or a cause.
Exceptions should be meaningful and contain as much detail about the error case as possible. This will help to track
down an underlying issue in a better way.

## Noncompliant Code

```kotlin
fun foo(bar: Int) {
    if (bar < 1) {
        throw IllegalArgumentException()
    }
    // ...
}
```
## Compliant Code

```kotlin
fun foo(bar: Int) {
    if (bar < 1) {
        throw IllegalArgumentException("bar must be greater than zero")
    }
    // ...
}
```

[Source](https://detekt.dev/docs/rules/exceptions#throwingexceptionswithoutmessageorcause)

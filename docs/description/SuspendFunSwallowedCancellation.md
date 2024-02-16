# SuspendFunSwallowedCancellation

`suspend` functions should not be called inside `runCatching`'s lambda block, because `runCatching` catches all the
`Exception`s. For Coroutines to work in all cases, developers should make sure to propagate `CancellationException`
exceptions. This means `CancellationException` should never be:
* caught and swallowed (even if logged)
* caught and propagated to external systems
* caught and shown to the user

they must always be rethrown in the same context.

Using `runCatching` increases this risk of mis-handling cancellation. If you catch and don't rethrow all the
`CancellationException`, your coroutines are not cancelled even if you cancel their `CoroutineScope`.

This can very easily lead to:
* unexpected crashes
* extremely hard to diagnose bugs
* memory leaks
* performance issues
* battery drain

See reference, [Kotlin doc](https://kotlinlang.org/docs/cancellation-and-timeouts.html#cancellation-is-cooperative).

If your project wants to use `runCatching` and `Result` objects, it is recommended to write a `coRunCatching`
utility function which immediately re-throws `CancellationException`; and forbid `runCatching` and `suspend`
combinations by activating this rule.

## Noncompliant Code

```kotlin
@Throws(IllegalStateException::class)
suspend fun bar(delay: Long) {
    check(delay <= 1_000L)
    delay(delay)
}

suspend fun foo() {
    runCatching {
        bar(1_000L)
    }
}
```
## Compliant Code

```kotlin
@Throws(IllegalStateException::class)
suspend fun bar(delay: Long) {
    check(delay <= 1_000L)
    delay(delay)
}

suspend fun foo() {
    try {
        bar(1_000L)
    } catch (e: IllegalStateException) {
        // handle error
    }
}

// Alternate
@Throws(IllegalStateException::class)
suspend fun foo() {
    bar(1_000L)
}
```

[Source](https://arturbosch.github.io/detekt/coroutines.html#suspendfunswallowedcancellation)

# SuspendFunWithCoroutineScopeReceiver

Suspend functions that use `CoroutineScope` as receiver should not be marked as `suspend`.
A `CoroutineScope` provides structured concurrency via its `coroutineContext`. A `suspend`
function also has its own `coroutineContext`, which is now ambiguous and mixed with the
receiver`s.

See https://kotlinlang.org/docs/coroutines-basics.html#scope-builder-and-concurrency

## Noncompliant Code

```kotlin
suspend fun CoroutineScope.foo() {
    launch {
      delay(1.seconds)
    }
}
```
## Compliant Code

```kotlin
fun CoroutineScope.foo() {
    launch {
      delay(1.seconds)
    }
}

// Alternative
suspend fun foo() = coroutineScope {
    launch {
      delay(1.seconds)
    }
}
```

[Source](https://detekt.dev/docs/rules/coroutines#suspendfunwithcoroutinescopereceiver)

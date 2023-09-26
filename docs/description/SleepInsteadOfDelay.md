# SleepInsteadOfDelay

Report usages of `Thread.sleep` in suspending functions and coroutine blocks. A thread can
contain multiple coroutines at one time due to coroutines' lightweight nature, so if one
coroutine invokes `Thread.sleep`, it could potentially halt the execution of unrelated coroutines
and cause unpredictable behavior.

## Noncompliant Code

```kotlin
suspend fun foo() {
    Thread.sleep(1_000L)
}
```
## Compliant Code

```kotlin
suspend fun foo() {
    delay(1_000L)
}
```

[Source](https://detekt.github.io/detekt/coroutines.html#sleepinsteadofdelay)

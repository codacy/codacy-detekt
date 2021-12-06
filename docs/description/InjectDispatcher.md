# InjectDispatcher

Always use dependency injection to inject dispatchers for easier testing.
This rule is based on the recommendation
https://developer.android.com/kotlin/coroutines/coroutines-best-practices#inject-dispatchers

## Noncompliant Code

```kotlin
fun myFunc() {
coroutineScope(Dispatchers.IO)
}
```
## Compliant Code

```kotlin
fun myFunc(dispatcher: CoroutineDispatcher = Dispatchers.IO) {
coroutineScope(dispatcher)
}

class MyRepository(dispatchers: CoroutineDispatcher = Dispatchers.IO)
```

[Source](https://arturbosch.github.io/detekt/coroutines.html#injectdispatcher)

Do not rethrow a caught exception of the same type.

```kotlin
//Bad:

try {
    //...
}
catch (e: SomeException) {
    throw e
}
```

[Source](https://github.com/arturbosch/detekt/)
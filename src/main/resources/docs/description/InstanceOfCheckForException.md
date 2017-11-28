Instead of checking for a general exception type and checking for a specific exception type you can use multiple catch blocks.

```kotlin
//Example:

try {
    ...
} catch (ex: Exception) {
    when(ex) {
        is FooException, is BarException -> {
            ...
        }
        else -> throw ex
    }
}
```

[Source](https://github.com/arturbosch/detekt/)
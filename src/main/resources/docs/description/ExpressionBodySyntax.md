Writing simple functions is Kotlin idiomatic programming style.

It makes the code shorter and more readable.

This can be done with or without explicitly declaring the return type of the function

```kotlin
//Bad:

fun ping(): Pong {
    return Pong()
}

//Good, explicit return type:

fun Ping(): Pong = Pong()

//Also good, implicit return type

fun Ping() = Pong()
```

[Source](https://stackoverflow.com/questions/7128348/performance-difference-between-a-wild-card-import-and-the-required-class-import)

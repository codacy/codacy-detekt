Cast operator throws an exception if the cast is not possible. 
To avoid an exception being thrown, you can use a safe cast operator as? that returns null on failure.

```kotlin
//Bad:

val x: String = y as String

//Good:

val x: String? = y as? String
```

[Source](https://kotlinlang.org/docs/reference/typecasts.html)
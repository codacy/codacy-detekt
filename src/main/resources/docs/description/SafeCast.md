Use safe cast instead of if-else-null.

```kotlin
//Bad:

if(foo != null) {
    foo.length
}

//Good:

foo?.length

```

[Source](https://github.com/arturbosch/detekt/)
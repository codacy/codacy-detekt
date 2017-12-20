```kotlin
//Bad:

try {
    ...
}
catch (e: SomeException) {
    ...
}
finally {}

//Good:

try {
    ...
}
catch (e: SomeException) {
    ...
}

```

[Source](https://github.com/arturbosch/detekt)
Empty try-catch is a bad idea because you are ignoring an error condition and then continuing execution.

```kotlin
//Bad:

try {
    //...
} catch {

}
```

[Source](https://stackoverflow.com/questions/1234343/why-are-empty-catch-blocks-a-bad-idea/1234364)
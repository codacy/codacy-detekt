Consider using `==` to compare to null instead of `.equals(null)`.
```kotlin
//Bad:

if (b.equals(null) && b.length > 0) {
    print("String of length ${b.length}")
} else {
    print("Empty string")
}

//Good:

if (b != null && b.length > 0) {
    print("String of length ${b.length}")
} else {
    print("Empty string")
}
```

[Source](https://kotlinlang.org/docs/reference/null-safety.html)
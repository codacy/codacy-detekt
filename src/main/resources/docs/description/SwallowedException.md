# SwallowedException

Exceptions should not be swallowed. This rule reports all instances where exceptions are `caught` and not correctly
passed into a newly thrown exception.

## Noncompliant Code

```kotlin
fun foo() {
    try {
        // ...
    } catch(e: IOException) {
        throw MyException(e.message) // e is swallowed
    }
}
```
## Compliant Code

```kotlin
fun foo() {
    try {
        // ...
    } catch(e: IOException) {
        throw MyException(e)
    }
}
```

[Source](https://arturbosch.github.io/detekt/exceptions.html#swallowedexception)

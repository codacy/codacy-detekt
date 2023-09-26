# SwallowedException

Exceptions should not be swallowed. This rule reports all instances where exceptions are `caught` and not correctly
passed (e.g. as a cause) into a newly thrown exception.

The exception types configured in `ignoredExceptionTypes` indicate nonexceptional outcomes.
These by default configured exception types are part of Java.
Therefore, Kotlin developers have to handle them by using the catch clause.
For that reason, this rule ignores that these configured exception types are caught.

## Noncompliant Code

```kotlin
fun foo() {
    try {
        // ...
    } catch(e: IOException) {
        throw MyException(e.message) // e is swallowed
    }
    try {
        // ...
    } catch(e: IOException) {
        throw MyException() // e is swallowed
    }
    try {
        // ...
    } catch(e: IOException) {
        bar() // exception is unused
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
    try {
        // ...
    } catch(e: IOException) {
        println(e) // logging is ok here
    }
}
```

[Source](https://detekt.github.io/detekt/exceptions.html#swallowedexception)

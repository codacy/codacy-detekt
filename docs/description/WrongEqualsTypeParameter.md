# WrongEqualsTypeParameter

Reports equals() methods which take in a wrongly typed parameter.
Correct implementations of the equals() method should only take in a parameter of type Any?
See: https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/equals.html

## Noncompliant Code

```kotlin
class Foo {

    fun equals(other: String): Boolean {
        return super.equals(other)
    }
}
```
## Compliant Code

```kotlin
class Foo {

    fun equals(other: Any?): Boolean {
        return super.equals(other)
    }
}
```

[Source](https://detekt.dev/docs/rules/potential-bugs#wrongequalstypeparameter)

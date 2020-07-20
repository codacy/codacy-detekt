# EqualsAlwaysReturnsTrueOrFalse

Reports equals() methods which will always return true or false.

Equals methods should always report if some other object is equal to the current object.
See the Kotlin documentation for Any.equals(other: Any?):
https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/equals.html

## Noncompliant Code

```kotlin
override fun equals(other: Any?): Boolean {
    return true
}
```
## Compliant Code

```kotlin
override fun equals(other: Any?): Boolean {
    return this === other
}
```

[Source](https://arturbosch.github.io/detekt/potential-bugs.html#equalsalwaysreturnstrueorfalse)

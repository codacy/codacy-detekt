# OptionalAbstractKeyword

This rule reports `abstract` modifiers which are unnecessary and can be removed.

## Noncompliant Code

```kotlin
abstract interface Foo { // abstract keyword not needed

    abstract fun x() // abstract keyword not needed
    abstract var y: Int // abstract keyword not needed
}
```
## Compliant Code

```kotlin
interface Foo {

    fun x()
    var y: Int
}
```

[Source](https://arturbosch.github.io/detekt/style.html#optionalabstractkeyword)

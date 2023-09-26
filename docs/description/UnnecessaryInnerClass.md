# UnnecessaryInnerClass

This rule reports unnecessary inner classes. Nested classes that do not access members from the outer class do
not require the `inner` qualifier.

## Noncompliant Code

```kotlin
class A {
    val foo = "BAR"

    inner class B {
        val fizz = "BUZZ"

        fun printFizz() {
            println(fizz)
        }
    }
}
```

[Source](https://detekt.github.io/detekt/style.html#unnecessaryinnerclass)

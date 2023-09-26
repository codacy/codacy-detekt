# ClassOrdering

This rule ensures class contents are ordered as follows as recommended by the Kotlin
[Coding Conventions](https://kotlinlang.org/docs/coding-conventions.html#class-layout):
- Property declarations and initializer blocks
- Secondary constructors
- Method declarations
- Companion object

## Noncompliant Code

```kotlin
class OutOfOrder {
    companion object {
        const val IMPORTANT_VALUE = 3
    }

    fun returnX(): Int {
        return x
    }

    private val x = 2
}
```
## Compliant Code

```kotlin
class InOrder {
    private val x = 2

    fun returnX(): Int {
        return x
    }

    companion object {
        const val IMPORTANT_VALUE = 3
    }
}
```

[Source](https://detekt.github.io/detekt/style.html#classordering)

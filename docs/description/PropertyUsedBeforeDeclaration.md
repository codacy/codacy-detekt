# PropertyUsedBeforeDeclaration

Reports properties that are used before declaration.

## Noncompliant Code

```kotlin
class C {
    private val number
        get() = if (isValid) 1 else 0

    val list = listOf(number)

    private val isValid = true
}

fun main() {
    println(C().list) // [0]
}
```
## Compliant Code

```kotlin
class C {
    private val isValid = true

    private val number
        get() = if (isValid) 1 else 0

    val list = listOf(number)
}

fun main() {
    println(C().list) // [1]
}
```

[Source](https://arturbosch.github.io/detekt/potential-bugs.html#propertyusedbeforedeclaration)

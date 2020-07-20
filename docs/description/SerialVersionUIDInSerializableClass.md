# SerialVersionUIDInSerializableClass

Classes which implement the `Serializable` interface should also correctly declare a `serialVersionUID`.
This rule verifies that a `serialVersionUID` was correctly defined.

## Noncompliant Code

```kotlin
class IncorrectSerializable : Serializable {

    companion object {
        val serialVersionUID = 1 // wrong declaration for UID
    }
}
```
## Compliant Code

```kotlin
class CorrectSerializable : Serializable {

    companion object {
        const val serialVersionUID = 1L
    }
}
```

[Source](https://arturbosch.github.io/detekt/style.html#serialversionuidinserializableclass)

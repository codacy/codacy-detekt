# SerialVersionUIDInSerializableClass

Classes which implement the `Serializable` interface should also correctly declare a `serialVersionUID`.
This rule verifies that a `serialVersionUID` was correctly defined and declared as `private`.

[More about `SerialVersionUID`](https://docs.oracle.com/javase/7/docs/api/java/io/Serializable.html)

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

[Source](https://detekt.dev/docs/rules/style#serialversionuidinserializableclass)

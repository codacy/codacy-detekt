# HasPlatformType

Platform types must be declared explicitly in public APIs to prevent unexpected errors.

## Noncompliant Code

```kotlin
class Person {
    fun apiCall() = System.getProperty("propertyName")
}
```
## Compliant Code

```kotlin
class Person {
    fun apiCall(): String = System.getProperty("propertyName")
}
```

[Source](https://detekt.dev/docs/rules/potential-bugs#hasplatformtype)

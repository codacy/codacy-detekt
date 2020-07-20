# HasPlatformType

Platform types must be declared explicitly in public APIs to prevent unexpected errors.

Based on code from Kotlin project:
https://github.com/JetBrains/kotlin/blob/1.3.50/idea/src/org/jetbrains/kotlin/idea/intentions/SpecifyTypeExplicitlyIntention.kt#L86-L107

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

[Source](https://arturbosch.github.io/detekt/potential-bugs.html#hasplatformtype)

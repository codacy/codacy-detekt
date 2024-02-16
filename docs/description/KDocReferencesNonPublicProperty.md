# KDocReferencesNonPublicProperty

This rule will report any KDoc comments that refer to non-public properties of a class.
Clients do not need to know the implementation details.

## Noncompliant Code

```kotlin
/**
* Comment
* [prop1] - non-public property
* [prop2] - public property
*/
class Test {
    private val prop1 = 0
    val prop2 = 0
}
```
## Compliant Code

```kotlin
/**
* Comment
* [prop2] - public property
*/
class Test {
    private val prop1 = 0
    val prop2 = 0
}
```

[Source](https://detekt.dev/docs/rules/comments#kdocreferencesnonpublicproperty)

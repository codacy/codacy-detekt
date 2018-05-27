# ProtectedMemberInFinalClass

Kotlin classes are `final` by default. Thus classes which are not marked as `open` should not contain any `protected`
members. Consider using `private` or `internal` modifiers instead.

## Noncompliant Code

```kotlin
class ProtectedMemberInFinalClass {
    protected var i = 0
}
```
## Compliant Code

```kotlin
class ProtectedMemberInFinalClass {
    private var i = 0
}
```

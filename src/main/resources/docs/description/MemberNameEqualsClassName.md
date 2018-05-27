# MemberNameEqualsClassName

This rule reports a member that has the same as the containing class or object.
This might result in confusion.
The member should either be renamed or changed to a constructor.
Factory functions that create an instance of the class are exempt from this rule.

## Noncompliant Code

```kotlin
class MethodNameEqualsClassName {

    fun methodNameEqualsClassName() { }
}

class PropertyNameEqualsClassName {

    val propertyEqualsClassName = 0
}
```
## Compliant Code

```kotlin
class Manager {

    companion object {
        // factory functions can have the same name as the class
        fun manager(): Manager {
            return Manager()
        }
    }
}
```

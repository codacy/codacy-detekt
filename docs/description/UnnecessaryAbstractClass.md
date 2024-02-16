# UnnecessaryAbstractClass

This rule inspects `abstract` classes. In case an `abstract class` does not have any concrete members it should be
refactored into an interface. Abstract classes which do not define any `abstract` members should instead be
refactored into concrete classes.

## Noncompliant Code

```kotlin
abstract class OnlyAbstractMembersInAbstractClass { // violation: no concrete members

    abstract val i: Int
    abstract fun f()
}

abstract class OnlyConcreteMembersInAbstractClass { // violation: no abstract members

    val i: Int = 0
    fun f() { }
}
```
## Compliant Code

```kotlin
interface OnlyAbstractMembersInInterface {
    val i: Int
    fun f()
}

class OnlyConcreteMembersInClass {
    val i: Int = 0
    fun f() { }
}
```

[Source](https://detekt.github.io/detekt/style.html#unnecessaryabstractclass)

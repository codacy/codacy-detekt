# EqualsWithHashCodeExist

When a class overrides the equals() method it should also override the hashCode() method.

All hash-based collections depend on objects meeting the equals-contract. Two equal objects must produce the
same hashcode. When inheriting equals or hashcode, override the inherited and call the super method for
clarification.

## Noncompliant Code

```kotlin
class Foo {

    override fun equals(other: Any?): Boolean {
        return super.equals(other)
    }
}
```
## Compliant Code

```kotlin
class Foo {

    override fun equals(other: Any?): Boolean {
        return super.equals(other)
    }

    override fun hashCode(): Int {
        return super.hashCode()
    }
}
```

[Source](https://detekt.dev/docs/rules/potential-bugs#equalswithhashcodeexist)

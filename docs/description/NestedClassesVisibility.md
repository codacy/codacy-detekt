# NestedClassesVisibility

Nested classes inherit their visibility from the parent class
and are often used to implement functionality local to the class it is nested in.
These nested classes can't have a higher visibility than their parent.
However, the visibility can be further restricted by using a private modifier for instance.
In internal classes the _explicit_ public modifier for nested classes is misleading and thus unnecessary,
because the nested class still has an internal visibility.

## Noncompliant Code

```kotlin
internal class Outer {
    // explicit public modifier still results in an internal nested class
    public class Nested
}
```
## Compliant Code

```kotlin
internal class Outer {
    class Nested1
    internal class Nested2
}
```

[Source](https://detekt.dev/docs/rules/style#nestedclassesvisibility)

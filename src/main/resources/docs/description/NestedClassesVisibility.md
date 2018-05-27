# NestedClassesVisibility

Nested classes are often used to implement functionality local to the class it is nested in. Therefore it should
not be public to other parts of the code.
Prefer keeping nested classes `private`.

## Noncompliant Code

```kotlin
internal class NestedClassesVisibility {

    public class NestedPublicClass // should not be public
}
```
## Compliant Code

```kotlin
internal class NestedClassesVisibility {

    internal class NestedPublicClass
}
```

[Source](https://arturbosch.github.io/detekt/style.html#nestedclassesvisibility)

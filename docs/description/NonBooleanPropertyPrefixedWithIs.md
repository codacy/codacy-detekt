# NonBooleanPropertyPrefixedWithIs

Reports when property with 'is' prefix doesn't have a boolean type.
Please check the [chapter 8.3.2 at Java Language Specification](https://docs.oracle.com/javase/specs/jls/se8/html/jls-8.html#jls-8.3.2)

## Noncompliant Code

```kotlin
val isEnabled: Int = 500
```
## Compliant Code

```kotlin
val isEnabled: Boolean = false
```

[Source](https://detekt.github.io/detekt/naming.html#nonbooleanpropertyprefixedwithis)

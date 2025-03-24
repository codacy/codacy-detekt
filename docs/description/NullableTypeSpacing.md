# NullableTypeSpacing

No spaces in a nullable type.

## Noncompliant Code

```kotlin

    val foo: String ? = null
    val foo: List<String ?> = listOf(null)
    
```
## Compliant Code

```kotlin

    val foo: String? = null
    val foo: List<String?> = listOf(null)
    
```

[Source](https://detekt.dev/docs/rules/formatting#nullabletypespacing)

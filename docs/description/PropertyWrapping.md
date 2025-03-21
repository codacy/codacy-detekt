# PropertyWrapping

When a property doesn't fit on a single line, wrap the type or value to a separate line

## Noncompliant Code

```kotlin

    // Assume that the last allowed character is
    // at the X character on the right           X
    val aVariableWithALooooooooooooongName: String
    
```
## Compliant Code

```kotlin

    // Assume that the last allowed character is
    // at the X character on the right           X
    val aVariableWithALooooooooooooongName:
        String
    
```

[Source](https://detekt.dev/docs/rules/formatting#propertywrapping)

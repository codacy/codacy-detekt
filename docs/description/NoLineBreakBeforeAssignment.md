# NoLineBreakBeforeAssignment

When a line is broken at an assignment (`=`) operator the break comes after the symbol.

## Noncompliant Code

```kotlin

    val valA
        = ""
    
```
## Compliant Code

```kotlin

    val valA =
        ""
    
```

[Source](https://detekt.dev/docs/rules/formatting#nolinebreakbeforeassignment)

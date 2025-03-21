# ArgumentListWrapping

All arguments should be on the same line, or every argument should be on a separate line.

## Noncompliant Code

```kotlin

    val x = f(
        a,
        b, c
    )
    
```
## Compliant Code

```kotlin

    val x = f(
        a,
        b,
        c
    )
    
```

[Source](https://detekt.dev/docs/rules/formatting#argumentlistwrapping)

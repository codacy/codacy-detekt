# Wrapping

Inserts missing newlines (for example between parentheses of a multi-line function call).

## Noncompliant Code

```kotlin

    val x = f(
        a,
        b,
        c)
    
```
## Compliant Code

```kotlin

    val x = f(
        a,
        b,
        c
    )
    
```

[Source](https://detekt.dev/docs/rules/formatting#wrapping)

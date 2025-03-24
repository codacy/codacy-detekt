# ParameterWrapping

When a function or class parameter doesn't fit on a single line, wrap the type or value to a separate line

## Noncompliant Code

```kotlin

    // Assume that the last allowed character is
    // at the X character on the right           X
    class Bar(
        val fooooooooooooooooooooooooTooLong: Foo,
    )
    fun bar(
        fooooooooooooooooooooooooooooTooLong: Foo,
    )
    
```

[Source](https://detekt.dev/docs/rules/formatting#parameterwrapping)

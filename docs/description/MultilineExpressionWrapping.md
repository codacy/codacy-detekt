# MultilineExpressionWrapping

Multiline expression on the right hand side of an expression are forced to start on a separate line. Expressions in return statement are excluded as that would result in a compilation error.

## Noncompliant Code

```kotlin
val foo = foo(
    parameterName = "The quick brown fox "
        .plus("jumps ")
        .plus("over the lazy dog"),
)
```
## Compliant Code

```kotlin
val foo =
    foo(
        parameterName =
            "The quick brown fox "
                .plus("jumps ")
                .plus("over the lazy dog"),
    )
```

[Source](https://detekt.dev/docs/rules/formatting#multilineexpressionwrapping)

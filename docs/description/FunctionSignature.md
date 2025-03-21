# FunctionSignature

Rewrites the function signature to a single line when possible (e.g. when not exceeding the `max_line_length` property) or a multiline signature otherwise. In case of function with a body expression, the body expression is placed on the same line as the function signature when not exceeding the `max_line_length` property. Optionally the function signature can be forced to be written as a multiline signature in case the function has more than a specified number of parameters (`.editorconfig` property `ktlint_function_signature_wrapping_rule_always_with_minimum_parameters`)

## Noncompliant Code

```kotlin

    // Assume that the last allowed character is
    // at the X character on the right           X
    fun foooooooo(a: Any, b: Any, c: Any): String {
        // body
    }

    // Assume that the last allowed character is
    // at the X character on the right           X
    fun bar(
        a: Any,
        b: Any,
        c: Any
    ): String {
        // body
    }

    // When wrapping of body is set to 'default'.
    // Assume that the last allowed character is
    // at the X character on the right           X
    fun f(a: Any, b: Any): String =
        "some-result"
            .uppercase()

    // When wrapping of body is set to 'multiline'
    // or 'always'.
    // Assume that the last allowed character is
    // at the X character on the right           X
    fun f(a: Any, b: Any): String = "some-result"
        .uppercase()
    
```
## Compliant Code

```kotlin

    // Assume that the last allowed character is
    // at the X character on the right           X
    fun foooooooo(
        a: Any,
        b: Any,
        c: Any
    ): String {
        // body
    }

    // Assume that the last allowed character is
    // at the X character on the right           X
    fun bar(a: Any, b: Any, c: Any): String {
        // body
    }

    // When wrapping of body is set to 'default'.
    // Assume that the last allowed character is
    // at the X character on the right           X
    fun f(a: Any, b: Any): String = "some-result"
        .uppercase()

    // When wrapping of body is set to 'multiline'
    // or 'always'.
    // Assume that the last allowed character is
    // at the X character on the right           X
    fun f(a: Any, b: Any): String =
        "some-result"
            .uppercase()
    
```

[Source](https://detekt.dev/docs/rules/formatting#functionsignature)

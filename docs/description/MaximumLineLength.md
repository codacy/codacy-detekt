# MaximumLineLength

Ensures that lines do not exceed the given length of `.editorconfig` property `max_line_length` (see [EditorConfig](../configuration-ktlint/) section for more). This rule does not apply in a number of situations. For example, in the case a line exceeds the maximum line length due to a comment that disables ktlint rules then that comment is being ignored when validating the length of the line. The `.editorconfig` property `ktlint_ignore_back_ticked_identifier` can be set to ignore identifiers which are enclosed in backticks, which for example is very useful when you want to allow longer names for unit tests.

## Noncompliant Code

```kotlin

    // Assume that the last allowed character is
    // at the X character on the right           X
    val fooooooooooooooo = "fooooooooooooooooooooo"
    val foooooooooooooo = "foooooooooooooooooooo" // some comment
    val fooooooooooooo =
        "foooooooooooooooooooooooooooooooooooooooo"
    
```
## Compliant Code

```kotlin

    // Assume that the last allowed character is
    // at the X character on the right           X
    // Lines below are accepted although the max
    // line length is exceeded.
    package com.toooooooooooooooooooooooooooo.long
    import com.tooooooooooooooooooooooooooooo.long
    val foo =
        """
        fooooooooooooooooooooooooooooooooooooooooo
        """
    @Test
    fun `Test description which is toooooooooooo long`() {
    }
    
```

[Source](https://detekt.dev/docs/rules/formatting#maximumlinelength)

# MultilineRawStringIndentation

This rule ensures that raw strings have a consistent indentation.

The content of a multi line raw string should have the same indentation as the enclosing expression plus the
configured indentSize. The closing triple-quotes (`"""`)  must have the same indentation as the enclosing expression.

## Noncompliant Code

```kotlin
val a = """
Hello World!
How are you?
""".trimMargin()

val a = """
    Hello World!
    How are you?
    """.trimMargin()
```
## Compliant Code

```kotlin
val a = """
    Hello World!
    How are you?
""".trimMargin()

val a = """
    Hello World!
      How are you?
""".trimMargin()
```

[Source](https://detekt.dev/docs/rules/style#multilinerawstringindentation)

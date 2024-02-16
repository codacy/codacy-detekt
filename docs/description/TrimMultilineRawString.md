# TrimMultilineRawString

All the Raw strings that have more than one line should be followed by `trimMargin()` or `trimIndent()`.

## Noncompliant Code

```kotlin
"""
Hello World!
How are you?
"""
```
## Compliant Code

```kotlin
"""
  Hello World!
  How are you?
""".trimMargin()

"""
Hello World!
How are you?
""".trimIndent()

"""Hello World! How are you?"""
```

[Source](https://detekt.github.io/detekt/style.html#trimmultilinerawstring)

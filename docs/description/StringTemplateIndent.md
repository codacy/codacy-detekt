# StringTemplateIndent

Enforce consistent string template indentation for multiline string templates which are post-fixed with . The opening and closing are placed on separate lines and the indentation of the content of the template is aligned with the .

## Noncompliant Code

```kotlin
"""
```
## Compliant Code

```kotlin
.trimIndent()
```

[Source](https://detekt.dev/docs/rules/formatting#stringtemplateindent)

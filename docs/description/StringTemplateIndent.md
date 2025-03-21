# StringTemplateIndent

Enforce consistent string template indentation for multiline string templates which are post-fixed with `.trimIndent()`. The opening and closing `"""` are placed on separate lines and the indentation of the content of the template is aligned with the `"""`.

## Noncompliant Code

```kotlin

    val foo = """
              line1
              line2
              """.trimIndent()
    fun foo() {
        return """
            line1
            line2
        """.trimIndent()
    }
    
```
## Compliant Code

```kotlin

    val foo =
        """
        line1
        line2
        """.trimIndent()
    fun foo() {
        // The opening """ can not be wrapped to next line as that would result in a compilation error
        return """
            line1
            line2
            """.trimIndent()
    }
    
```

[Source](https://detekt.dev/docs/rules/formatting#stringtemplateindent)

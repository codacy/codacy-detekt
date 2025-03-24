# Indentation

Indentation formatting - respects `.editorconfig` `indent_size` with no continuation indent (see [EditorConfig](../configuration-ktlint/) section for more).

## Noncompliant Code

```kotlin

    fun main() {
        foobar(
              a,
              b,
              c
              )
    }
    
```
## Compliant Code

```kotlin

    fun main() {
        foobar(
            a,
            b,
            c
        )
    }
    
```

[Source](https://detekt.dev/docs/rules/formatting#indentation)

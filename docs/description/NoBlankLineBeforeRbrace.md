# NoBlankLineBeforeRbrace

`}`

No blank lines before `}`.

## Noncompliant Code

```kotlin

    fun main() {
        fun a() {

        }
        fun b()

    }
    
```
## Compliant Code

```kotlin

    fun main() {
        fun a() {
        }
        fun b()
    }
    
```

[Source](https://detekt.dev/docs/rules/formatting#noblanklinebeforerbrace)

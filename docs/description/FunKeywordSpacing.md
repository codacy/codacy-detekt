# FunKeywordSpacing

Consistent spacing after the fun keyword.

## Noncompliant Code

```kotlin

    fun  foo() = "some-result"
    fun
    foo() = "some-result"
    
```
## Compliant Code

```kotlin

    fun foo() = "some-result"
    
```

[Source](https://detekt.dev/docs/rules/formatting#funkeywordspacing)

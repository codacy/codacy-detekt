# UnnecessaryParenthesesBeforeTrailingLambda

An empty parentheses block before a lambda is redundant.

## Noncompliant Code

```kotlin

    "some-string".count() { it == '-' }
    
```
## Compliant Code

```kotlin

    "some-string".count { it == '-' }
    
```

[Source](https://detekt.dev/docs/rules/formatting#unnecessaryparenthesesbeforetrailinglambda)

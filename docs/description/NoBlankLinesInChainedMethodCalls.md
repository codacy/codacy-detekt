# NoBlankLinesInChainedMethodCalls



## Noncompliant Code

```kotlin

    fun foo(inputText: String) {
        inputText

            .lowercase(Locale.getDefault())
    }
    
```
## Compliant Code

```kotlin

    fun foo(inputText: String) {
        inputText
            .lowercase(Locale.getDefault())
    }
    
```

[Source](https://detekt.dev/docs/rules/formatting#noblanklinesinchainedmethodcalls)

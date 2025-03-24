# NoMultipleSpaces

Except in indentation and in KDoc's it is not allowed to have multiple consecutive spaces.

## Noncompliant Code

```kotlin

    fun  main()  {
        x(1,  3)
    }
    
```
## Compliant Code

```kotlin

    fun main() {
        x(1, 3)
    }
    
```

[Source](https://detekt.dev/docs/rules/formatting#nomultiplespaces)

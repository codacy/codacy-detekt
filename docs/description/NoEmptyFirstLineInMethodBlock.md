# NoEmptyFirstLineInMethodBlock



## Noncompliant Code

```kotlin

    fun bar() {

       val a = 2
    }
    
```
## Compliant Code

```kotlin

    fun bar() {
       val a = 2
    }
    
```

[Source](https://detekt.dev/docs/rules/formatting#noemptyfirstlineinmethodblock)

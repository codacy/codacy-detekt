# FunctionReturnTypeSpacing

Consistent spacing around the function return type.

## Noncompliant Code

```kotlin

    fun foo1() : String = "some-result"
    fun foo2():  String = "some-result"
    fun foo3():String = "some-result"
    fun foo4():
        String = "some-result"
    
```
## Compliant Code

```kotlin

    fun foo(): String = "some-result"
    
```

[Source](https://detekt.dev/docs/rules/formatting#functionreturntypespacing)

# FunctionStartOfBodySpacing

Consistent spacing before start of function body.

## Noncompliant Code

```kotlin

    fun foo1()= "some-result"
    fun foo2()
        = "some-result"
    fun foo3()
    {
        // do something
    }
    fun bar1(): String= "some-result"
    fun bar2(): String
        = "some-result"
    fun bar3(): String
    {
        return "some-result"
    }
    
```
## Compliant Code

```kotlin

    fun foo1() = "some-result"
    fun foo2() =
        "some-result"
    fun foo3() {
        // do something
    }
    fun bar1(): String = "some-result"
    fun bar2(): String =
        "some-result"
    fun bar3(): String {
        return "some-result"
    }
    
```

[Source](https://detekt.dev/docs/rules/formatting#functionstartofbodyspacing)

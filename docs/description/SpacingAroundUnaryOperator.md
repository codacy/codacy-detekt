# SpacingAroundUnaryOperator

No spaces around unary operators.

## Noncompliant Code

```kotlin

    fun foo1(i: Int) = i ++
    fun foo2(i: Int) = ++ i
    fun foo3(i: Int) = ++
        i
    
```
## Compliant Code

```kotlin

    fun foo1(i: Int) = i++
    fun foo2(i: Int) = ++i
    fun foo3(i: Int) = ++i
    
```

[Source](https://detekt.dev/docs/rules/formatting#spacingaroundunaryoperator)

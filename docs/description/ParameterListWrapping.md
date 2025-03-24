# ParameterListWrapping

When class/function signature doesn't fit on a single line, each parameter must be on a separate line

## Compliant Code

```kotlin

    class ClassA(paramA: String, paramB: String, paramC: String)
    class ClassA(
        paramA: String,
        paramB: String,
        paramC: String
    )
    fun f(a: Any, b: Any, c: Any)
    fun f(
        a: Any,
        b: Any,
        c: Any
    )
    fun foo(
        @Bar fooBar: FooBar
    )
    
```

[Source](https://detekt.dev/docs/rules/formatting#parameterlistwrapping)

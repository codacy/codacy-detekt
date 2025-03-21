# FunctionName

Enforce naming of function.

## Noncompliant Code

```kotlin

    fun Foo() {}
    fun Foo_Bar() {}
    fun `Some name`() {}
    fun do_something() {}
    
```
## Compliant Code

```kotlin

    fun foo() {}
    fun fooBar() {}
    
```

[Source](https://detekt.dev/docs/rules/formatting#functionname)

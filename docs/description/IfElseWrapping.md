# IfElseWrapping

A single line if-statement should be kept simple. It may contain no more than one else-branch. The branches may not be wrapped in a block.

## Noncompliant Code

```kotlin

    fun foobar() {
        if (true) if (false) foo() else bar()
        if (true) bar() else if (false) foo() else bar()
        if (true) { foo() } else bar()
        if (true) bar() else { if (false) foo() else bar() }
    }
    
```
## Compliant Code

```kotlin

    fun foobar() {
        if (true) foo()
        if (true) foo() else bar()
    }
    
```

[Source](https://detekt.dev/docs/rules/formatting#ifelsewrapping)

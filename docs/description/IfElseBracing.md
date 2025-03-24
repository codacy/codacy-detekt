# IfElseBracing

If at least one branch of an if-else statement or an if-else-if statement is wrapped between curly braces then all branches should be wrapped between braces.

## Noncompliant Code

```kotlin

    fun foo(value: int) {
        if (value > 0)
            doSomething()
        else if (value < 0) {
            doSomethingElse()
        } else
            doSomethingElse2()
    }
    
```
## Compliant Code

```kotlin

    fun foo(value: int) {
        if (value > 0) {
            doSomething()
        } else if (value < 0) {
            doSomethingElse()
        } else {
            doSomethingElse2()
        }
    }
    
```

[Source](https://detekt.dev/docs/rules/formatting#ifelsebracing)

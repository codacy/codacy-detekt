# NoLineBreakAfterElse

Disallows line breaks after the else keyword if that could lead to confusion, for example:

## Noncompliant Code

```kotlin

    fun funA() {
        if (conditionA()) {
            doSomething()
        } else
        if (conditionB()) {
            doAnotherThing()
        }
    }
    
```
## Compliant Code

```kotlin

    fun funA() {
        if (conditionA()) {
            doSomething()
        } else if (conditionB()) {
            doAnotherThing()
        }
    }
    
```

[Source](https://detekt.dev/docs/rules/formatting#nolinebreakafterelse)

# UselessPostfixExpression

This rule reports postfix expressions (++, --) which are unused and thus unnecessary.
This leads to confusion as a reader of the code might think the value will be incremented/decremented.
However the value is replaced with the original value which might lead to bugs.

## Noncompliant Code

```kotlin
var i = 0
i = i--
i = 1 + i++
i = i++ + 1

fun foo(): Int {
    var i = 0
    // ...
    return i++
}
```
## Compliant Code

```kotlin
var i = 0
i--
i = i + 2
i = i + 2

fun foo(): Int {
    var i = 0
    // ...
    i++
    return i
}
```

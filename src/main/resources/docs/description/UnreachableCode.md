# UnreachableCode

Reports unreachable code.
Code can be unreachable because it is behind return, throw, continue or break expressions.
This unreachable code should be removed as it serves no purpose.

## Noncompliant Code

```kotlin
for (i in 1..2) {
    break
    println() // unreachable
}

throw IllegalArgumentException()
println() // unreachable

fun f() {
    return
    println() // unreachable
}
```

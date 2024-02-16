# ReturnFromFinally

Reports all `return` statements in `finally` blocks.
Using `return` statements in `finally` blocks can discard and hide exceptions that are thrown in the `try` block.
Furthermore, this rule reports values from `finally` blocks, if the corresponding `try` is used as an expression.

## Noncompliant Code

```kotlin
fun foo() {
    try {
        throw MyException()
    } finally {
        return // prevents MyException from being propagated
    }
}

val a: String = try { "s" } catch (e: Exception) { "e" } finally { "f" }
```

[Source](https://detekt.dev/docs/rules/exceptions#returnfromfinally)

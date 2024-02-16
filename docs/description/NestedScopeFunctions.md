# NestedScopeFunctions

Although the scope functions are a way of making the code more concise, avoid overusing them: it can decrease
your code readability and lead to errors. Avoid nesting scope functions and be careful when chaining them:
it's easy to get confused about the current context object and the value of this or it.

[Reference](https://kotlinlang.org/docs/scope-functions.html)

## Noncompliant Code

```kotlin
// Try to figure out, what changed, without knowing the details
first.apply {
    second.apply {
        b = a
        c = b
    }
}
```
## Compliant Code

```kotlin
// 'a' is a property of current class
// 'b' is a property of class 'first'
// 'c' is a property of class 'second'
first.b = this.a
second.c = first.b
```

[Source](https://detekt.github.io/detekt/complexity.html#nestedscopefunctions)

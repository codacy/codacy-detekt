# ChainWrapping

When wrapping chained calls `.`, `?.` and `?:` should be placed on the next line

## Noncompliant Code

```kotlin

    val foo = listOf(1, 2, 3).
        filter { it > 2 }!!.
        takeIf { it.count() > 100 }?.
        sum()
    val foobar = foo() ?:
        bar
    
```
## Compliant Code

```kotlin

    val foo = listOf(1, 2, 3)
        .filter { it > 2 }!!
        .takeIf { it.count() > 100 }
        ?.sum()
    val foobar = foo()
        ?: bar
    
```

[Source](https://detekt.dev/docs/rules/formatting#chainwrapping)

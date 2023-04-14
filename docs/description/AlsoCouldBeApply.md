# AlsoCouldBeApply

Detects when an `also` block contains only `it`-started expressions.

By refactoring the `also` block to an `apply` block makes it so that all `it`s can be removed
thus making the block more concise and easier to read.

## Noncompliant Code

```kotlin
Buzz().also {
it.init()
it.block()
}
```
## Compliant Code

```kotlin
Buzz().apply {
init()
block()
}

// Also compliant
fun foo(a: Int): Int {
return a.also { println(it) }
}
```

[Source](https://arturbosch.github.io/detekt/style.html#alsocouldbeapply)

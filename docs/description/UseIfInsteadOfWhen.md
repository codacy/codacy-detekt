# UseIfInsteadOfWhen

Binary expressions are better expressed using an `if` expression than a `when` expression.

See [if versus when](https://kotlinlang.org/docs/coding-conventions.html#if-versus-when)

## Noncompliant Code

```kotlin
when (x) {
    null -> true
    else -> false
}
```
## Compliant Code

```kotlin
if (x == null) true else false
```

[Source](https://detekt.github.io/detekt/style.html#useifinsteadofwhen)

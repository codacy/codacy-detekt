# MultilineLambdaItParameter

Lambda expressions are very useful in a lot of cases, and they often include very small chunks of
code using only one parameter. In this cases Kotlin can supply the implicit `it` parameter
to make code more concise. However, when you are dealing with lambdas that contain multiple statements,
you might end up with code that is hard to read if you don't specify a readable, descriptive parameter name
explicitly.

## Noncompliant Code

```kotlin
val digits = 1234.let {
    println(it)
    listOf(it)
}

val digits = 1234.let { it ->
    println(it)
    listOf(it)
}

val flat = listOf(listOf(1), listOf(2)).mapIndexed { index, it ->
    println(it)
    it + index
}
```
## Compliant Code

```kotlin
val digits = 1234.let { explicitParameterName ->
    println(explicitParameterName)
    listOf(explicitParameterName)
}

val lambda = { item: Int, that: String ->
    println(item)
    item.toString() + that
}

val digits = 1234.let { listOf(it) }
val digits = 1234.let {
    listOf(it)
}
val digits = 1234.let { it -> listOf(it) }
val digits = 1234.let { it ->
    listOf(it)
}
val digits = 1234.let { explicit -> listOf(explicit) }
val digits = 1234.let { explicit ->
    listOf(explicit)
}
```

[Source](https://arturbosch.github.io/detekt/style.html#multilinelambdaitparameter)

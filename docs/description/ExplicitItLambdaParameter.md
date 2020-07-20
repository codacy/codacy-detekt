# ExplicitItLambdaParameter

Lambda expressions are one of the core features of the language. They often include very small chunks of
code using only one parameter. In this cases Kotlin can supply the implicit `it` parameter
to make code more concise. It fits most usecases, but when faced larger or nested chunks of code,
you might want to add an explicit name for the parameter. Naming it just `it` is meaningless and only
makes your code misleading, especially when dealing with nested functions.

## Noncompliant Code

```kotlin
a?.let { it -> it.plus(1) }
foo.flatMapObservable { it -> Observable.fromIterable(it) }
listOfPairs.map(::second).forEach { it ->
    it.execute()
}
collection.zipWithNext { it, next -> Pair(it, next) }
```
## Compliant Code

```kotlin
a?.let { it.plus(1) } // Much better to use implicit it
foo.flatMapObservable(Observable::fromIterable) // Here we can have a method reference

// For multiline blocks it is usually better come up with a clear and more meaningful name
listOfPairs.map(::second).forEach { apiRequest ->
    apiRequest.execute()
}

// Lambdas with multiple parameter should be named clearly, using it for one of them can be confusing
collection.zipWithNext { prev, next ->
    Pair(prev, next)
}
```

[Source](https://arturbosch.github.io/detekt/style.html#explicititlambdaparameter)

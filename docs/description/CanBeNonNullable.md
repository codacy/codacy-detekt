# CanBeNonNullable

This rule inspects variables marked as nullable and reports which could be
declared as non-nullable instead.

It's preferred to not have functions that do "nothing".
A function that does nothing when the value is null hides the logic,
so it should not allow null values in the first place.
It is better to move the null checks up around the calls,
instead of having it inside the function.

This could lead to less nullability overall in the codebase.

## Noncompliant Code

```kotlin
class A {
    var a: Int? = 5

    fun foo() {
        a = 6
    }
}

class A {
    val a: Int?
        get() = 5
}

fun foo(a: Int?) {
    val b = a!! + 2
}

fun foo(a: Int?) {
    if (a != null) {
        println(a)
    }
}

fun foo(a: Int?) {
    if (a == null) return
    println(a)
}
```
## Compliant Code

```kotlin
class A {
    var a: Int = 5

    fun foo() {
        a = 6
    }
}

class A {
    val a: Int
        get() = 5
}

fun foo(a: Int) {
    val b = a + 2
}

fun foo(a: Int) {
    println(a)
}
```

[Source](https://detekt.github.io/detekt/style.html#canbenonnullable)

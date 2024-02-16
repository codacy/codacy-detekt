# NoNameShadowing

Disallows shadowing variable declarations.
Shadowing makes it impossible to access a variable with the same name in the scope.

## Noncompliant Code

```kotlin
fun test(i: Int, j: Int, k: Int) {
    val i = 1
    val (j, _) = 1 to 2
    listOf(1).map { k -> println(k) }
    listOf(1).forEach {
        listOf(2).forEach {
        }
    }
}
```
## Compliant Code

```kotlin
fun test(i: Int, j: Int, k: Int) {
    val x = 1
    val (y, _) = 1 to 2
    listOf(1).map { z -> println(z) }
    listOf(1).forEach {
        listOf(2).forEach { x ->
        }
    }
}
```

[Source](https://detekt.dev/docs/rules/naming#nonameshadowing)

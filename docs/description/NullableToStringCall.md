# NullableToStringCall

Reports `toString()` calls with a nullable receiver that may return the string "null".

## Noncompliant Code

```kotlin
fun foo(a: Any?): String {
    return a.toString()
}

fun bar(a: Any?): String {
    return "$a"
}
```
## Compliant Code

```kotlin
fun foo(a: Any?): String {
    return a?.toString() ?: "-"
}

fun bar(a: Any?): String {
    return "${a ?: "-"}"
}
```

[Source](https://arturbosch.github.io/detekt/potential-bugs.html#nullabletostringcall)

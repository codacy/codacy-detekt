# UnsafeCast

Reports casts that will never succeed.

## Noncompliant Code

```kotlin
fun foo(s: String) {
    println(s as Int)
}

fun bar(s: String) {
    println(s as? Int)
}
```
## Compliant Code

```kotlin
fun foo(s: Any) {
    println(s as Int)
}
```

[Source](https://detekt.dev/docs/rules/potential-bugs#unsafecast)

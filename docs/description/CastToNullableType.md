# CastToNullableType

Disallow to cast to nullable types.
There are cases where `as String?` is misused as safe cast (`as? String`).
So if you want to prevent those cases, turn on this rule.

## Noncompliant Code

```kotlin
fun foo(a: Any?) {
    val x: String? = a as String? // If 'a' is not String, ClassCastException will be thrown.
}
```
## Compliant Code

```kotlin
fun foo(a: Any?) {
    val x: String? = a as? String
}
```

[Source](https://detekt.github.io/detekt/potential-bugs.html#casttonullabletype)

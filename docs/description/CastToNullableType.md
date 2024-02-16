# CastToNullableType

Reports unsafe cast to nullable types.
`as String?` is unsafed and may be misused as safe cast (`as? String`).

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

[Source](https://detekt.dev/docs/rules/potential-bugs#casttonullabletype)

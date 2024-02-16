# CastNullableToNonNullableType

Reports cast of nullable variable to non-null type. Cast like this can hide `null`
problems in your code. The compliant code would be that which will correctly check
for two things (nullability and type) and not just one (cast).

## Noncompliant Code

```kotlin
fun foo(bar: Any?) {
    val x = bar as String
}
```
## Compliant Code

```kotlin
fun foo(bar: Any?) {
    val x = checkNotNull(bar) as String
}

// Alternative
fun foo(bar: Any?) {
    val x = (bar ?: error("null assertion message")) as String
}
```

[Source](https://detekt.dev/docs/rules/potential-bugs#castnullabletononnullabletype)

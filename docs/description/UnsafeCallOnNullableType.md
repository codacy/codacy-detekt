# UnsafeCallOnNullableType

Reports unsafe calls on nullable types. These calls will throw a NullPointerException in case
the nullable value is null. Kotlin provides many ways to work with nullable types to increase
null safety. Guard the code appropriately to prevent NullPointerExceptions.

## Noncompliant Code

```kotlin
fun foo(str: String?) {
    println(str!!.length)
}
```
## Compliant Code

```kotlin
fun foo(str: String?) {
    println(str?.length)
}
```

[Source](https://detekt.dev/docs/rules/potential-bugs#unsafecallonnullabletype)

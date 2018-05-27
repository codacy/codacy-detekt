# UnsafeCast

Reports casts which are unsafe. In case the cast is not possible it will throw an exception.

## Noncompliant Code

```kotlin
fun foo(s: Any) {
    println(s as Int)
}
```
## Compliant Code

```kotlin
fun foo(s: Any) {
    println((s as? Int) ?: 0)
}
```

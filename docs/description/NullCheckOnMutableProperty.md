# NullCheckOnMutableProperty

Reports null-checks on mutable properties, as these properties' value can be
changed - and thus make the null-check invalid - after the execution of the
if-statement.

## Noncompliant Code

```kotlin
class A(private var a: Int?) {
fun foo() {
    if (a != null) {
      println(2 + a!!)
    }
}
}
```
## Compliant Code

```kotlin
class A(private val a: Int?) {
fun foo() {
    if (a != null) {
      println(2 + a)
    }
}
}
```

[Source](https://detekt.github.io/detekt/potential-bugs.html#nullcheckonmutableproperty)

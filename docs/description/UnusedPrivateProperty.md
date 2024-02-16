# UnusedPrivateProperty

An unused private property can be removed to simplify the source file.

This rule also detects unused constructor parameters since these can become
properties of the class when they are declared with `val` or `var`.

## Noncompliant Code

```kotlin
class Foo {
private val unused = "unused"
}
```
## Compliant Code

```kotlin
class Foo {
private val used = "used"

fun greet() {
    println(used)
}
}
```

[Source](https://detekt.dev/docs/rules/style#unusedprivateproperty)

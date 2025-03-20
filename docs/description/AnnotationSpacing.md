# AnnotationSpacing

Annotations should be separated by a single line break.

## Noncompliant Code

```kotlin
@JvmField

fun foo() {}

@Foo @Bar
/**
 * block comment
 */
class FooBar {
}
```
## Compliant Code

```kotlin
@JvmField
fun foo() {}

/**
 * block comment
 */
@Foo @Bar
class FooBar {
}
```

[Source](https://detekt.dev/docs/rules/formatting#annotationspacing)

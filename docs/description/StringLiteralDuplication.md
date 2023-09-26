# StringLiteralDuplication

This rule detects and reports duplicated String literals. Repeatedly typing out the same String literal across the
codebase makes it harder to change and maintain.

Instead, prefer extracting the String literal into a property or constant.

## Noncompliant Code

```kotlin
class Foo {

    val s1 = "lorem"
    fun bar(s: String = "lorem") {
        s1.equals("lorem")
    }
}
```
## Compliant Code

```kotlin
class Foo {
    val lorem = "lorem"
    val s1 = lorem
    fun bar(s: String = lorem) {
        s1.equals(lorem)
    }
}
```

[Source](https://detekt.github.ioekt/complexity.html#stringliteralduplication)

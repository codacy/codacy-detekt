# DestructuringDeclarationWithTooManyEntries

Destructuring declarations with too many entries are hard to read and understand.
To increase readability they should be refactored to reduce the number of entries or avoid using a destructuring
declaration.

## Noncompliant Code

```kotlin
data class TooManyElements(val a: Int, val b: Int, val c: Int, val d: Int)
val (a, b, c, d) = TooManyElements(1, 2, 3, 4)
```
## Compliant Code

```kotlin
data class FewerElements(val a: Int, val b: Int, val c: Int)
val (a, b, c) = TooManyElements(1, 2, 3)
```

[Source](https://detekt.github.io/detekt/style.html#destructuringdeclarationwithtoomanyentries)

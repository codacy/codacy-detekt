# LabeledExpression

This rule reports labeled expressions. Expressions with labels generally increase complexity and worsen the
maintainability of the code. Refactor the violating code to not use labels instead.
Labeled expressions referencing an outer class with a label from an inner class are allowed, because there is no
way to get the instance of an outer class from an inner class in Kotlin.

## Noncompliant Code

```kotlin
val range = listOf<String>("foo", "bar")
loop@ for (r in range) {
    if (r == "bar") break@loop
    println(r)
}
```
## Compliant Code

```kotlin
val range = listOf<String>("foo", "bar")
for (r in range) {
    if (r == "bar") break
    println(r)
}

class Outer {
    inner class Inner {
        fun f() {
            val outer = this@Outer
        }
    }
}
```

[Source](https://arturbosch.github.io/detekt/complexity.html#labeledexpression)

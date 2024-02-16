# UnnecessaryInheritance

This rule reports unnecessary super types. Inheriting from `Any` or `Object` is unnecessary and should simply be
removed.

## Noncompliant Code

```kotlin
class A : Any()
class B : Object()
```

[Source](https://detekt.github.io/detekt/style.html#unnecessaryinheritance)

# SpacingAroundParens

Consistent spacing around parenthesis.

## Noncompliant Code

```kotlin
class Foo : Bar {
    constructor(string: String) : super ()
}
val foo1 = ( (1 + 2 ) / 3)
```
## Compliant Code

```kotlin
class Foo : Bar {
    constructor(string: String) : super()
}
val foo1 = ((1 + 2) / 3)
```

[Source](https://detekt.dev/docs/rules/formatting#spacingaroundparens)

# PreferToOverPairSyntax

This rule detects the usage of the Pair constructor to create pairs of values.

Using `<value1>` to `<value2>` is preferred.

## Noncompliant Code

```kotlin
val pair = Pair(1, 2)
```
## Compliant Code

```kotlin
val pair = 1 to 2
```

[Source](https://detekt.dev/docs/rules/style#prefertooverpairsyntax)

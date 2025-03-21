# SpacingAroundAngleBrackets

No spaces around angle brackets when used for typing.

## Noncompliant Code

```kotlin
val a: Map< Int, String> = mapOf()
val b: Map<Int, String > = mapOf()
val c: Map <Int, String> = mapOf()
```
## Compliant Code

```kotlin
val a: Map<Int, String> = mapOf()
val b: Map<Int, String> = mapOf()
val c: Map<Int, String> = mapOf()
```

[Source](https://detekt.dev/docs/rules/formatting#spacingaroundanglebrackets)

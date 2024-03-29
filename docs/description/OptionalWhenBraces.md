# OptionalWhenBraces

This rule reports unnecessary braces in when expressions. These optional braces should be removed.

## Noncompliant Code

```kotlin
val i = 1
when (i) {
    1 -> { println("one") } // unnecessary curly braces since there is only one statement
    else -> println("else")
}
```
## Compliant Code

```kotlin
val i = 1
when (i) {
    1 -> println("one")
    else -> println("else")
}
```

[Source](https://detekt.dev/docs/rules/style#optionalwhenbraces)

# NamedArguments

Reports function invocations which have more arguments than a certain threshold and are all not named. Calls with
too many arguments are more difficult to understand so a named arguments help.

## Noncompliant Code

```kotlin
fun sum(a: Int, b: Int, c: Int, d: Int) {
}
sum(1, 2, 3, 4)
```
## Compliant Code

```kotlin
fun sum(a: Int, b: Int, c: Int, d: Int) {
}
sum(a = 1, b = 2, c = 3, d = 4)
```

[Source](https://detekt.dev/docs/rules/complexity#namedarguments)

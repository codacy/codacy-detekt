# UseCheckNotNull

Turn on this rule to flag `check` calls for not-null check that can be replaced with a `checkNotNull` call.

## Noncompliant Code

```kotlin
check(x != null)
```
## Compliant Code

```kotlin
checkNotNull(x)
```

[Source](https://detekt.dev/docs/rules/style#usechecknotnull)

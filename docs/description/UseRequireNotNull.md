# UseRequireNotNull

Turn on this rule to flag `require` calls for not-null check that can be replaced with a `requireNotNull` call.

## Noncompliant Code

```kotlin
require(x != null)
```
## Compliant Code

```kotlin
requireNotNull(x)
```

[Source](https://detekt.dev/docs/rules/style#userequirenotnull)

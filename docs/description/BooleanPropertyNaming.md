# BooleanPropertyNaming

Reports when a boolean property doesn't match a pattern

## Noncompliant Code

```kotlin
val progressBar: Boolean = true
```
## Compliant Code

```kotlin
val hasProgressBar: Boolean = true
```

[Source](https://detekt.dev/docs/rules/naming#booleanpropertynaming)

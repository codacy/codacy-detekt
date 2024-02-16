# EqualsNullCall

To compare an object with `null` prefer using `==`. This rule detects and reports instances in the code where the
`equals()` method is used to compare a value with `null`.

## Noncompliant Code

```kotlin
fun isNull(str: String) = str.equals(null)
```
## Compliant Code

```kotlin
fun isNull(str: String) = str == null
```

[Source](https://detekt.dev/docs/rules/style#equalsnullcall)

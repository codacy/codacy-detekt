# ForbiddenSuppress

Report suppressions of all forbidden rules.

This rule allows to set a list of [rules] whose suppression is forbidden.
This can be used to discourage the abuse of the `Suppress` and `SuppressWarnings` annotations.

This rule is not capable of reporting suppression of itself, as that's a language feature with precedence.

## Noncompliant Code

```kotlin
package foo

// When the rule "MaximumLineLength" is forbidden
@Suppress("MaximumLineLength", "UNCHECKED_CAST")
class Bar
```
## Compliant Code

```kotlin
package foo

// When the rule "MaximumLineLength" is forbidden
@Suppress("UNCHECKED_CAST")
class Bar
```

[Source](https://arturbosch.github.io/detekt/style.html#forbiddensuppress)

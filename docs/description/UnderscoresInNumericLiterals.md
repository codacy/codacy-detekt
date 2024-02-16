# UnderscoresInNumericLiterals

This rule detects and reports long base 10 numbers which should be separated with underscores
for readability. For `Serializable` classes or objects, the field `serialVersionUID` is
explicitly ignored. For floats and doubles, anything to the right of the decimal point is ignored.

## Noncompliant Code

```kotlin
const val DEFAULT_AMOUNT = 1000000
```
## Compliant Code

```kotlin
const val DEFAULT_AMOUNT = 1_000_000
```

[Source](https://detekt.dev/docs/rules/style#underscoresinnumericliterals)

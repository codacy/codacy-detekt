# UnderscoresInNumericLiterals

This rule detects and reports decimal base 10 numeric literals above a certain length that should be underscore
separated for readability. Underscores that do not make groups of 3 digits are also reported even if their length is
under the `acceptableDecimalLength`. For `Serializable` classes or objects, the field `serialVersionUID` is
explicitly ignored. For floats and doubles, anything to the right of the decimal is ignored.

## Noncompliant Code

```kotlin
object Money {
    const val DEFAULT_AMOUNT = 1000000
}
```
## Compliant Code

```kotlin
object Money {
    const val DEFAULT_AMOUNT = 1_000_000
}
```

[Source](https://arturbosch.github.io/detekt/style.html#underscoresinnumericliterals)

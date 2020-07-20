# ImplicitDefaultLocale

Prefer passing [java.util.Locale] explicitly than using implicit default value when formatting
strings or performing a case conversion.

The default locale is almost always not appropriate for machine-readable text like HTTP headers.
For example, if locale with tag `ar-SA-u-nu-arab` is a current default then `%d` placeholders
will be evaluated to numbers consisting of Eastern-Arabic (non-ASCII) digits.
[java.util.Locale.US] is recommended for machine-readable output.

## Noncompliant Code

```kotlin
String.format("Timestamp: %d", System.currentTimeMillis())

val str: String = getString()
str.toUpperCase()
str.toLowerCase()
```
## Compliant Code

```kotlin
String.format(Locale.US, "Timestamp: %d", System.currentTimeMillis())

val str: String = getString()
str.toUpperCase(Locale.US)
str.toLowerCase(Locale.US)
```

[Source](https://arturbosch.github.io/detekt/potential-bugs.html#implicitdefaultlocale)

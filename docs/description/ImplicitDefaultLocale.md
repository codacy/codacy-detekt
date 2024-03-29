# ImplicitDefaultLocale

Prefer passing [java.util.Locale] explicitly than using implicit default value when formatting
strings or performing a case conversion.

The default locale is almost always inappropriate for machine-readable text like HTTP headers.
For example, if locale with tag `ar-SA-u-nu-arab` is a current default then `%d` placeholders
will be evaluated to a number consisting of Eastern-Arabic (non-ASCII) digits.
[java.util.Locale.US] is recommended for machine-readable output.

## Noncompliant Code

```kotlin
String.format("Timestamp: %d", System.currentTimeMillis())
```
## Compliant Code

```kotlin
String.format(Locale.US, "Timestamp: %d", System.currentTimeMillis())
```

[Source](https://detekt.dev/docs/rules/potential-bugs#implicitdefaultlocale)

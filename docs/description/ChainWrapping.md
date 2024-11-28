# Checks if condition chaining is wrapped right

_This pattern description was written by a Codacy bot for detekt. Send feedback to ai-patterns@codacy.com_

## Description

See [ktlint docs](https://pinterest.github.io/ktlint/0.50.0/rules/standard/#chain-wrapping) for documentation.

**Description:**
When using chained calls in your Kotlin code, you must place the operators `.` (dot), `?.` (safe call), and `?:` (Elvis operator) on the next line. This formatting rule helps improve code readability and maintainability by clearly separating the chained calls from the preceding expressions.

**Error Example:**
```kotlin
val result = someObject.method1().method2().method3()
```
In the example above, the chained calls are not compliant with the linting rule.

**How to Fix:**
To resolve this error, modify your code so that the operators are on a new line. Here’s how you can correct the previous) for documentation.

**Active by default**: Yes - Since v1.0.0

#### Configuration options:

* ``indentSize`` (default: ``4``)

  indentation size 

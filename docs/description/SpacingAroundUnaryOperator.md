# Reports spaces around unary operator

_This pattern description was written by a Codacy bot for detekt. Send feedback to ai-patterns@codacy.com_

## Description

See [ktlint docs](https://pinterest.github.io/ktlint/0.50.0/rules/standard/#unary-operator-spacing) for documentation.

**Description:**
This linting error occurs when there are spaces placed around unary operators (like `++` or `--`) in your Kotlin code. According to Kotlin coding conventions, unary operators should not have spaces before or after them. This helps maintain a clean and consistent code style, making it easier to read and understand.

**Example of the Error:**
```kotlin
fun foo1(i: Int) = i ++ // Incorrect: Spaces around the unary operator
```

**How to Fix:**
To resolve this error, simply remove any spaces that are present around unary operators. Here’s how the corrected code should look:

```kotlin
fun foo1(i:) for documentation.

**Active by default**: Yes - Since v1.22.0 

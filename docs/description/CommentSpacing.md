# Checks if comments have the right spacing

_This pattern description was written by a Codacy bot for detekt. Send feedback to ai-patterns@codacy.com_

## Description

See [ktlint docs](### Linting Error: Improper End-of-Line Comment Formatting

**Description:**
Your code has an issue with the formatting of end-of-line comments. Specifically, the comment sign `//` must be preceded and followed by exactly one space. This helps maintain a consistent style and improves the readability of your code.

**Example of the Error:**

```kotlin
//comment // This comment is incorrectly formatted
var debugging = false//incorrect comment formatting
```

**How to Fix:**
To resolve this linting error, ensure that there is exactly one space before and after the `//` comment sign. Here’s how you can correct the examples above:

```kotlin
// comment // Correctly formatted comment
var debugging =) for documentation.

**Active by default**: Yes - Since v1.0.0 

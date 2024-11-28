# Checks the spacing between colon and return type.

_This pattern description was written by a Codacy bot for detekt. Send feedback to ai-patterns@codacy.com_

## Description

See [ktlint docs](https://pinterest.github.io/ktlint/0.50.0/rules/standard/#function-return-type-spacing) for documentation.

**Description:**
This linting error occurs when there is inconsistent spacing around the return type of a function in your Kotlin code. Proper formatting is essential for maintaining code readability and consistency across your codebase. 

**What to Fix:**
To resolve this error, ensure that there is exactly one space before and after the function return type. 

**Example of Incorrect Code:**
```kotlin
fun foo():String = "some-result"  // No space before return type
```

**Corrected Code:**
```kotlin
fun foo(): String = "some-result"  // Correct spacing
```

**Tips for Compliance:**
- Always check the) for
documentation.

**Active by default**: Yes - Since v1.23.0

#### Configuration options:

* ``maxLineLength`` (default: ``120``) (android default: ``100``)

  maximum line length 

# An enum should be a single line, or each enum entry has to be placed on a separate line.

_This pattern description was written by a Codacy bot for detekt. Send feedback to ai-patterns@codacy.com_

## Description

See [ktlint docs](https://pinterest.github.io/ktlint/0.50.0/rules/experimental/#enum-wrapping) for documentation.

**Error Description:**
This linting error occurs when the formatting of an enum in your Kotlin code does not adhere to the specified style guidelines. According to the ktlint rules, an enum declaration should be formatted in one of two ways:

1. **Single Line Format:** If the enum consists of a few entries, you can declare them all on a single line, separated by commas.
   
   **Example:**
   ```kotlin
   enum class Foo { A, B, C }
   ```

2. **Multi-Line Format:** If the enum has multiple entries, each entry should be placed on a separate line. Additionally, if there are any declarations (like properties or functions) within) for documentation.

**Active by default**: No

#### Configuration options:

* ``indentSize`` (default: ``4``)

  indentation size 

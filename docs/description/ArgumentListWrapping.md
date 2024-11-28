# Reports incorrect argument list wrapping

_This pattern description was written by a Codacy bot for detekt. Send feedback to ai-patterns@codacy.com_

## Description

See [ktlint docs](### Linting Error: Argument Formatting Issue

**Description:**
This linting error occurs when the formatting of function or method arguments does not adhere to the specified style guidelines. Specifically, all arguments must either be placed on the same line or each argument must be on a separate line. This ensures that the code remains readable and maintainable.

**How to Fix:**
To resolve this error, you have two options for formatting your arguments:

1. **Single Line Formatting:**
   If the function call has a manageable number of arguments, place them all on the same line, separated by commas. For example:

   ```kotlin
   val result = foo(a, b, c)
   ```

2. **Multi-Line Formatting:) for documentation.

**Active by default**: Yes - Since v1.22.0

#### Configuration options:

* ``indentSize`` (default: ``4``)

  indentation size

* ``maxLineLength`` (default: ``120``) (android default: ``100``)

  maximum line length 

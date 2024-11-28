# Detects mis-aligned parameter lists

_This pattern description was written by a Codacy bot for detekt. Send feedback to ai-patterns@codacy.com_

## Description

See [ktlint docs](### Linting Error: Function/Class Signature Formatting

**Description:**  
When your function or class signature is too long to fit on a single line, it is essential to format each parameter on a separate line. This enhances readability and maintains consistency across your codebase.

**How to Fix:**  
1. **Identify the Signature:** Look for functions or class constructors where the parameters are listed on a single line and exceed the line length limit.
  
2. **Reformat the Parameters:** Move each parameter to its own line, aligning them vertically for clarity. For example, change this:
   ```kotlin
   fun exampleFunction(param1: Type1, param2: Type2, param3: Type3)
   ```

   To) for documentation.

**Active by default**: Yes - Since v1.0.0

#### Configuration options:

* ``maxLineLength`` (default: ``120``) (android default: ``100``)

  maximum line length

* ``indentSize`` (default: ``4``)

  indentation size 

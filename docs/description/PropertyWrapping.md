# Type or value of properties must wrap if parameters don't fit on a single line

_This pattern description was written by a Codacy bot for detekt. Send feedback to ai-patterns@codacy.com_

## Description

See [ktlint docs](### Linting Error: Property Exceeds Line Length

**Description:**
This linting error occurs when a property declaration in your code is too long to fit on a single line. To maintain readability and adhere to coding standards, you need to wrap either the type or the value of the property onto a new line.

**How to Fix:**
To resolve this issue, you should break the long property declaration into two lines. You can choose to either:

1. Move the type to a new line:
   ```kotlin
   val aVariableWithALooooooooooooongName: 
       String = "This is a long string value that needs to be wrapped."
   ```

2. Move the value to a new line:) for documentation.

**Active by default**: Yes - Since v1.23.0

#### Configuration options:

* ``indentSize`` (default: ``4``)

  indentation size

* ``maxLineLength`` (default: ``120``) (android default: ``100``)

  maximum line length 

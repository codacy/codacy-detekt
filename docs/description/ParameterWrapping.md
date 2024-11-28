# Type or value of functions and class parameters must wrap if parameters don't fit on a single line

_This pattern description was written by a Codacy bot for detekt. Send feedback to ai-patterns@codacy.com_

## Description

See [ktlint docs](https://pinterest.github.io/ktlint/0.50.0/rules/standard/#parameter-wrapping) for documentation.

**Description**: This linting error occurs when a function or class parameter is too long to fit on a single line. When this happens, you need to wrap the type or value onto a new line to maintain readability and adhere to coding standards.

**How to Fix**: To resolve this issue, locate the parameter that exceeds the line length limit. You can either:

1. **Wrap the Type**: Move the type declaration to a new line. For example:
   ```kotlin
   fun exampleFunction(
       longParameterName: LongTypeThatIsReallyLong
   ) {
       // function body
   }
   ```

2. **Wrap the Value**:) for documentation.

**Active by default**: Yes - Since v1.23.0

#### Configuration options:

* ``indentSize`` (default: ``4``)

  indentation size

* ``maxLineLength`` (default: ``120``) (android default: ``100``)

  maximum line length 

# A single line if-statement may contain no more than one else-branch.

_This pattern description was written by a Codacy bot for detekt. Send feedback to ai-patterns@codacy.com_

## Description

See [ktlint docs](### Linting Error: Single Line If-Statement Complexity

**Description:**
This linting error occurs when a single line if-statement is not compliant with the ktlint guidelines. According to these guidelines, a single line if-statement should remain simple and straightforward. Specifically, it should adhere to the following rules:

1. **Single Else-Branch:** The if-statement can contain no more than one else-branch. This means that you cannot have multiple else-if conditions or nested else-statements within the same line.
   
2. **No Block Wrapping:** The branches of the if-statement (both if and else) should not be wrapped in curly braces `{}`. This is to maintain the simplicity and readability of the statement) for documentation.

**Active by default**: No

#### Configuration options:

* ``indentSize`` (default: ``4``)

  indentation size 

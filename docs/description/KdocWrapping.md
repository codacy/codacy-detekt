# Reports mis-indented code

_This pattern description was written by a Codacy bot for detekt. Send feedback to ai-patterns@codacy.com_

## Description

See [ktlint docs](https://pinterest.github.io/ktlint/0.50.0/rules/standard/#kdoc-wrapping) for documentation.

**Description:**
Your KDoc comment does not adhere to the required formatting standards. Specifically, a KDoc comment must start and end on a line that does not contain any other code elements. This helps maintain clarity and readability in your documentation.

**What You Need to Fix:**
To resolve this linting error, ensure that your KDoc comment is placed correctly. Here’s what you should do:

1. **Start the KDoc Comment on a New Line:** Make sure that the line before your KDoc comment is either empty or contains only whitespace.
   
2. **End the KDoc Comment on a New Line:** Similarly, the line following your KDoc comment should also be empty or contain only whitespace) for documentation.

**Active by default**: Yes - Since v1.23.0

#### Configuration options:

* ``indentSize`` (default: ``4``)

  indentation size 

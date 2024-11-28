# Multiline expression on the right hand side of an expression must start on a separate line.

_This pattern description was written by a Codacy bot for detekt. Send feedback to ai-patterns@codacy.com_

## Description

See [ktlint docs](https://pinterest.github.io/ktlint/0.50.0/rules/experimental/#multiline-expression-wrapping) for documentation.

#### Description:
This linting error occurs when a multiline expression is placed on the right-hand side of an expression without starting on a new line. In Kotlin, multiline expressions should begin on a separate line to enhance readability and maintain coding standards. However, there's an exception for expressions within return statements, as placing them on a new line would lead to compilation errors.

#### How to Fix:
1. **Identify the Multiline Expression**: Look for expressions that span multiple lines, especially those that are part of assignments or function calls.

2. **Reformat the Expression**: Ensure that the first line of the multiline expression starts on a new line. For example:
   ```kotlin) for
documentation.

**Active by default**: No

#### Configuration options:

* ``indentSize`` (default: ``4``)

  indentation size 

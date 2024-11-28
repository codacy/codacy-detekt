# Reports mis-indented code

_This pattern description was written by a Codacy bot for detekt. Send feedback to ai-patterns@codacy.com_

## Description

See [ktlint docs](### Linting Error: Block Comment Placement

**Error Message:** A block comment should start and end on a line that does not contain any other element.

#### Description:
This linting error occurs when a block comment is not properly isolated from other code elements. According to best practices, block comments should begin and end on lines that are free of any code, ensuring that they stand out clearly and do not interfere with the readability of the code.

#### Example of the Error:
```kotlin
// Some comment 1
val foo1 = "foo1"
val foo2 = "foo2" // Some comment 2
```

In the example above, the comments are placed on the same line as code elements, which violates the) for documentation.

**Active by default**: Yes - Since v1.23.0

#### Configuration options:

* ``indentSize`` (default: ``4``)

  indentation size 

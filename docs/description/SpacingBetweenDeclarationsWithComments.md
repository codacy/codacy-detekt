# Declarations and declarations with comments should have an empty space between.

_This pattern description was written by a Codacy bot for detekt. Send feedback to ai-patterns@codacy.com_

## Description

See [ktlint docs](### Linting Error: Missing Blank Line Between Declarations and Comments

**Description:**
This linting error occurs when there are comments associated with your declarations (like functions or variables) that are not separated by a blank line. To enhance code readability and maintainability, it is important to follow the convention of adding a blank line between a declaration and its preceding comment.

**How to Fix:**
To resolve this error, simply insert a blank line between your comments and the corresponding declarations. This practice helps to clearly delineate the comments from the code, making it easier for you and others to understand the purpose of the comments in relation to the code.

**Example of the Error:**

```kotlin
// some comment 1
bar)
for documentation.

**Active by default**: Yes - Since v1.22.0 

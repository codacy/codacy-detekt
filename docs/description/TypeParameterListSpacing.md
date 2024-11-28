# Check spacing after a type parameter list in function and class declarations.

_This pattern description was written by a Codacy bot for detekt. Send feedback to ai-patterns@codacy.com_

## Description

See [ktlint docs](### Linting Error: Spacing After Type Parameter List in Function and Class Declarations

**Description**: This linting error occurs when there is improper spacing after the type parameter list in your function or class declarations. Proper formatting is essential for code readability and maintenance.

**What to Fix**: Ensure that there is no extra space between the closing angle bracket `>` of the type parameter list and the function or class name. The correct syntax should have only a single space between the type parameter list and the function or class declaration.

**Example of Incorrect Code**:
```kotlin
fun <T>  foo1(t: T) = "some-result"
```
In the example above, there are two spaces between `>` and) for
documentation.

**Active by default**: No

#### Configuration options:

* ``indentSize`` (default: ``4``)

  indentation size 

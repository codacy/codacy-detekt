# Reports spaces in the type reference before a function.

_This pattern description was written by a Codacy bot for detekt. Send feedback to ai-patterns@codacy.com_

## Description

See [ktlint docs](### Linting Error: Incorrect Spacing Around Angle Brackets

**Description:**
This linting error occurs when there is improper spacing before and after the angle brackets (`<` and `>`) in a type argument list. Proper formatting is essential for maintaining code readability and consistency.

**Example of the Error:**
```kotlin
val res = ArrayList<LintError>()
```
In the above example, there is no space before or after the angle brackets, which is against the style guidelines enforced by ktlint.

**How to Fix:**
To resolve this issue, you should ensure that there is no space before the opening angle bracket and no space after the closing angle bracket. The corrected code should look like this:

```k) for
documentation.

**Active by default**: No

#### Configuration options:

* ``indentSize`` (default: ``4``)

  indentation size 

# Checks the spacing before and after the angle brackets of a type argument list.

_This pattern description was written by a Codacy bot for detekt. Send feedback to ai-patterns@codacy.com_

## Description

See [ktlint docs](### Linting Error: Inconsistent Spacing in Type Reference Before Function

#### Description
This linting error occurs when there is inconsistent spacing in the type reference before a function definition. Consistent spacing is crucial for maintaining readability and clarity in your code. 

#### Example of the Error
Consider the following code snippet:

```kotlin
fun String.foo() = "some-result"
```

In the above example, the spacing between the `String` type and the function name `foo` is incorrect. It should be consistent to enhance code readability.

#### How to Fix
To resolve this linting error, ensure that there is exactly one space between the type reference and the function name. Here’s the corrected version of the code:

```) for
documentation.

**Active by default**: Yes - Since v1.23.0 

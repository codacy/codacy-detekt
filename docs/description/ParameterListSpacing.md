# Ensure consistent spacing inside the parameter list.

_This pattern description was written by a Codacy bot for detekt. Send feedback to ai-patterns@codacy.com_

## Description

See [ktlint docs](### Linting Error: Inconsistent Spacing Inside Parameter List

#### Description
This linting error indicates that the spacing within the parameter list of a function is not consistent with the expected style guidelines. Proper formatting enhances code readability and maintainability, and adhering to consistent spacing conventions is an important aspect of clean code practices.

#### Example of the Error
Here’s an example of a function declaration that triggers this linting error:

```kotlin
fun foo(a: Any) = "some-result"
```

In the above example, the spacing around the colon (`:`) is inconsistent. The spacing before the parameter type should be uniform.

#### How to Fix
To resolve this error, ensure that there is a single space before and after the) for
documentation.

**Active by default**: No 

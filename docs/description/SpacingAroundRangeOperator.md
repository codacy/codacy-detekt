# Reports spaces around range operator

_This pattern description was written by a Codacy bot for detekt. Send feedback to ai-patterns@codacy.com_

## Description

See [ktlint docs](https://pinterest.github.io/ktlint/0.50.0/rules/standard/#range-spacing) for documentation.

#### Description
This linting error occurs when there is inconsistent or missing spacing around range operators in your Kotlin code. Consistent spacing improves code readability and maintains a standard coding style, which is essential for collaboration and code maintenance.

#### Example of the Error
Consider the following code snippet that triggers this linting error:

```kotlin
val foo1 = (1..12 step 2).last()
```

In this example, there is no space before and after the `..` range operator and the `step` keyword, which makes the code less readable.

#### How to Fix
To resolve this error, you need to ensure there is consistent spacing around the range operators) for documentation.

**Active by default**: Yes - Since v1.0.0 

# Reports spaces around colons

_This pattern description was written by a Codacy bot for detekt. Send feedback to ai-patterns@codacy.com_

## Description

See [ktlint docs](https://pinterest.github.io/ktlint/0.50.0/rules/standard/#colon-spacing) for documentation.

#### Description
This linting error indicates that there is inconsistent spacing around colons in your code. Proper formatting is essential for readability and maintaining a clean codebase. 

#### What to Fix
You need to ensure that there is a consistent amount of whitespace before and after colons in your class definitions. The correct format should have a single space before and after the colon.

#### Example of the Error
```kotlin
class A :B  // Incorrect: No space before B
class A2 : B2 // Incorrect: Space before B2 is correct, but ensure consistency throughout your code
```

#### How to Fix It
Update your class definitions to have a) for documentation.

**Active by default**: Yes - Since v1.0.0 

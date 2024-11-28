# Reports spaces around member invocation operator (dot).

_This pattern description was written by a Codacy bot for detekt. Send feedback to ai-patterns@codacy.com_

## Description

See [ktlint docs](https://pinterest.github.io/ktlint/0.50.0/rules/standard/#dot-spacing) for documentation.

**Description:**  
This linting error occurs when there is inconsistent spacing around the dot (`.`) operator in your Kotlin code. Consistent spacing is crucial for maintaining readability and adhering to Kotlin coding conventions.

**What to Look For:**  
Check for instances where a dot operator is used to access properties or methods on an object. The spacing around the dot should be consistent. Specifically, there should be no space before the dot and exactly one space after the dot when followed by a method or property.

**Example of Incorrect Spacing:**
```kotlin
fun String.foo() = "foo"
```
In the example above, there is no space before the dot, but) for documentation.

**Active by default**: Yes - Since v1.0.0 

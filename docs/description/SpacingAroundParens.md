# Reports spaces around parentheses

_This pattern description was written by a Codacy bot for detekt. Send feedback to ai-patterns@codacy.com_

## Description

See [ktlint docs](### Linting Error: Inconsistent Spacing Around Parentheses

**Description:**
This linting error occurs when there is inconsistent spacing around parentheses in your code. Consistent spacing is important for readability and maintaining a clean code style. 

**What to Fix:**
Ensure that there is a consistent use of spaces before and after parentheses for function calls, method definitions, and other scenarios where parentheses are used. 

**Example of the Error:**
```kotlin
class Foo : Bar {
    constructor(string: String) { // Incorrect spacing
        // ...
    }
}
```

**Corrected Example:**
```kotlin
class Foo : Bar {
    constructor(string: String) { // Correct spacing
        // ...
    }) for documentation.

**Active by default**: Yes - Since v1.0.0 

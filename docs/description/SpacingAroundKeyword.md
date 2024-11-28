# Reports spaces around keywords

_This pattern description was written by a Codacy bot for detekt. Send feedback to ai-patterns@codacy.com_

## Description

See [ktlint docs](### Linting Error: Inconsistent Spacing Around Keywords

**Description**: This linting error occurs when there is inconsistent spacing around keywords in your Kotlin code. Maintaining consistent spacing enhances readability and helps adhere to coding standards.

**What to Fix**: Ensure that there is exactly one space before and after keywords such as `if`, `for`, `fun`, etc. This applies to both the keyword itself and any parentheses or braces that follow or precede it.

**Example of the Error**:
```kotlin
fun main() {
    if(true) { // Incorrect: no space after 'if'
        // Code block
    }
}
```

**Corrected Example**:
```kotlin
fun main() {
    if) for documentation.

**Active by default**: Yes - Since v1.0.0 

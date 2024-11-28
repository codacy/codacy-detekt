# Check for consistent spacing before start of function body.

_This pattern description was written by a Codacy bot for detekt. Send feedback to ai-patterns@codacy.com_

## Description

See [ktlint docs](### Linting Error: Inconsistent Spacing Before Function Body

**Description:**  
This linting error occurs when there is inconsistent or incorrect spacing before the start of a function body in your Kotlin code. Consistent spacing is important for readability and maintaining a uniform coding style.

**How to Fix:**  
To resolve this error, ensure that there is a consistent amount of whitespace before the equals sign (`=`) that starts the function body. The preferred formatting typically requires a single space before the function body begins.

**Example of Incorrect Code:**
```kotlin
fun foo1()  = "some-result"  // Too much space before the '='
```

**Corrected Code:**
```kotlin
fun foo1() =) for
documentation.

**Active by default**: Yes - Since v1.23.0 

# Enforce consistent spacing in try-catch-finally blocks.

_This pattern description was written by a Codacy bot for detekt. Send feedback to ai-patterns@codacy.com_

## Description

See [ktlint docs](### Linting Error: Inconsistent Spacing in Try-Catch-Finally Blocks

**Description:**
This linting error occurs when the spacing within your `try`, `catch`, and `finally` blocks is inconsistent. Maintaining uniform spacing enhances code readability and adheres to Kotlin's style guidelines.

**Example of Non-Compliant Code:**
```kotlin
fun foo() {
    try {
        // do something
    } catch (e: Exception) {
        // handle exception
    } finally {
        // cleanup
    }
}
```

In the example above, there may be inconsistent indentation or spacing that does not align with the expected style.

**How to Fix:**
1. **Ensure Consistent Indentation:**) for
documentation.

**Active by default**: No

#### Configuration options:

* ``indentSize`` (default: ``4``)

  indentation size 

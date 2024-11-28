# Reports spaces around curly braces

_This pattern description was written by a Codacy bot for detekt. Send feedback to ai-patterns@codacy.com_

## Description

See [ktlint docs](https://pinterest.github.io/ktlint/0.50.0/rules/standard/#curly-spacing) for documentation.

**Description:**  
This linting error indicates that there is inconsistent spacing around curly braces in your code. Proper spacing enhances readability and maintains a clean code style, which is essential for collaborative projects and long-term maintenance.

**Example of Non-Compliant Code:**
```kotlin
val foo = bar { foo() }
```

**Corrected Code:**
```kotlin
val foo = bar { foo() }
```

In the example above, there is no space between the opening brace `{` and the preceding code, as well as no space between the closing brace `}` and the following code. To comply with the linting rules, ensure there is one) for documentation.

**Active by default**: Yes - Since v1.0.0 

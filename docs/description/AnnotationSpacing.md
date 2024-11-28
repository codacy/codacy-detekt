# There should not be empty lines between an annotation and the object that it's annotating

_This pattern description was written by a Codacy bot for detekt. Send feedback to ai-patterns@codacy.com_

## Description

See [ktlint docs](### Linting Error: Annotations Should Be Separated by a Single Line Break

**Description:**
This linting error occurs when multiple annotations in your Kotlin code are not properly separated by a single line break. According to the ktlint style guide, it is essential for readability and consistency that annotations are clearly delineated.

**Example of the Issue:**
```kotlin
@JvmField
@AnotherAnnotation
fun foo() {}
```

In the example above, the two annotations `@JvmField` and `@AnotherAnnotation` are placed directly one after the other without a line break, which triggers the linting error.

**How to Fix:**
To resolve this error, you should add a single blank line between the annotations) for documentation.

**Active by default**: Yes - Since v1.22.0 

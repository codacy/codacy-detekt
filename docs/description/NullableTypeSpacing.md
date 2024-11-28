# Ensure no spaces in nullable type.

_This pattern description was written by a Codacy bot for detekt. Send feedback to ai-patterns@codacy.com_

## Description

See [ktlint docs](### Linting Error: No Spaces in a Nullable Type

**Description:**
This linting error occurs when there are unnecessary spaces in the declaration of a nullable type in Kotlin. Kotlin's syntax requires that the nullable type indicator (`?`) be directly adjacent to the type without any intervening spaces.

**How to Fix:**
To resolve this error, ensure that there are no spaces between the type and the nullable indicator. 

**Example of Incorrect Code:**
```kotlin
val foo: String? = null  // This is correct
val bar: String ? = null // This will trigger the linting error
```

**Correct Code:**
```kotlin
val foo: String? = null  // Correct usage with) for
documentation.

**Active by default**: Yes - Since v1.23.0 

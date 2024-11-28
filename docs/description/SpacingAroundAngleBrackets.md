# Reports spaces around angle brackets

_This pattern description was written by a Codacy bot for detekt. Send feedback to ai-patterns@codacy.com_

## Description

See [ktlint docs](### Linting Error: No Spaces Around Angle Brackets

**Description:**
This linting error occurs when there are spaces around angle brackets (`<` and `>`) in type declarations. In Kotlin, it is essential to keep angle brackets for generics tightly coupled with the type names without any intervening spaces. This ensures clarity and consistency in your code.

**Example of the Error:**
```kotlin
val a : Map < Int, String > = mapOf()
```

**Corrected Code:**
To resolve this error, simply remove the spaces around the angle brackets. The corrected code should look like this:
```kotlin
val a: Map<Int, String> = mapOf()
```

**How to Fix) for documentation.

**Active by default**: Yes - Since v1.22.0 

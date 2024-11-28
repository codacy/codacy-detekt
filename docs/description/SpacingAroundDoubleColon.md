# Reports spaces around double colons

_This pattern description was written by a Codacy bot for detekt. Send feedback to ai-patterns@codacy.com_

## Description

See [ktlint docs](https://pinterest.github.io/ktlint/0.50.0/rules/standard/#double-colon-spacing) for documentation.

**Description:**
This linting error occurs when there are spaces surrounding the double colon operator (`::`) in Kotlin code. The `::` operator is used for referencing a class or a member, and it should be formatted without any spaces to maintain code consistency and readability.

**Example of the Error:**
```kotlin
val foo = Foo :: class  // Incorrect: spaces around `::`
```

**How to Fix:**
To resolve this error, simply remove any spaces around the `::` operator. The corrected code should look like this:
```kotlin
val foo = Foo::class  // Correct: no spaces around `::`
```

**Why It) for documentation.

**Active by default**: Yes - Since v1.22.0 

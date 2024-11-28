# Ensure consistent spacing between function name and opening parenthesis.

_This pattern description was written by a Codacy bot for detekt. Send feedback to ai-patterns@codacy.com_

## Description

See [ktlint docs](### Linting Error: Inconsistent Spacing Before Function Parenthesis

**Description:**
This linting error occurs when there is inconsistent spacing between a function name and its opening parenthesis. Maintaining consistent spacing enhances code readability and adheres to Kotlin style guidelines.

**How to Fix:**
To resolve this error, ensure that there is exactly one space between the function name and the opening parenthesis. For example, if your function definition looks like this:

```kotlin
fun foo() = "foo"
```

It is compliant because there is one space between `foo` and `(`. However, if it appears like this:

```kotlin
fun foo () = "foo"
```

You will encounter the linting error due) for
documentation.

**Active by default**: Yes - Since v1.23.0 

# Checks the spacing between the modifiers in and after the last modifier in a modifier list.

_This pattern description was written by a Codacy bot for detekt. Send feedback to ai-patterns@codacy.com_

## Description

See [ktlint docs](### Linting Error: Inconsistent Spacing in Modifier Lists

**Description:**
This linting error indicates that there is inconsistent spacing between modifiers in a modifier list, particularly after the last modifier. Proper formatting of modifiers enhances code readability and maintains a consistent style throughout your codebase.

**What You Need to Fix:**
To resolve this error, ensure that there is a single space between each modifier and that the last modifier in the list is also followed by a single space before any subsequent code. This applies to all modifiers such as `abstract`, `protected`, `suspend`, etc.

**Example of the Error:**
```kotlin
abstract class Foo {
    protected abstract suspend fun bar()
}
```

**Corrected Example:) for documentation.

**Active by default**: Yes - Since v1.23.0 

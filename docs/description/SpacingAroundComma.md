# Reports spaces around commas

_This pattern description was written by a Codacy bot for detekt. Send feedback to ai-patterns@codacy.com_

## Description

See [ktlint docs](### Linting Error: Inconsistent Spacing Around Commas

**Description:**
This linting error indicates that the spacing around commas in your code is not consistent. Proper spacing enhances code readability and maintains a clean coding style, which is essential for collaboration and maintenance.

**What to Fix:**
Ensure that there is a consistent amount of whitespace before and after commas in your code. The standard practice is to have a single space after each comma and no space before it.

**Example of Incorrect Code:**
```kotlin
val foo1 = Foo(1,  3)
val foo2 = Bar(5,6)
```

**Corrected Code:**
```kotlin
val foo1 = Foo(1,) for documentation.

**Active by default**: Yes - Since v1.0.0 

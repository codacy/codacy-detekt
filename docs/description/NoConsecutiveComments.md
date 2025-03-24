# NoConsecutiveComments

Consecutive comments are disallowed in following cases:
- Any mix of a consecutive kdoc, a block comment or an EOL comment unless separated by a blank line in between
- Consecutive KDocs (even when separated by a blank line)
- Consecutive block comments (even when separated by a blank line)

Consecutive EOL comments are always allowed as they are often used instead of a block comment.

## Noncompliant Code

```kotlin

    /*
     * Block comments can not be consecutive ...
     */
    /*
     * ... even not when separated by a new line.
     */
    val bar = "bar" 

    /**
      * A KDoc can not be followed by a block comment or an EOL comment or another KDOC
      */

    // ... even not when separated by a new line.
    
```
## Compliant Code

```kotlin

    // An EOL comment
    // may be followed by another EOL comment
    val foo = "foo"

    // Different comment types (including KDoc) may be consecutive ..

    /*
     * ... but do need to be separated by a blank line ...
     */

    /**
      * ... but a KDoc can not be followed by an EOL or a block comment or another KDoc
      */
    fun bar() = "bar"

    
```

[Source](https://detekt.dev/docs/rules/formatting#noconsecutivecomments)

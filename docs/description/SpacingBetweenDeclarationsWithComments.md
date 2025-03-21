# SpacingBetweenDeclarationsWithComments

Declarations with comments should be separated by a blank line.

## Noncompliant Code

```kotlin

    // some comment 1
    bar()
    /*
     * some comment 2
     */
    foo()
    
```
## Compliant Code

```kotlin

    // some comment 1
    bar()

    /*
     * some comment 2
     */
    foo()
    
```

[Source](https://detekt.dev/docs/rules/formatting#spacingbetweendeclarationswithcomments)

# BlockCommentInitialStarAlignment

Lines in a block comment which (exclusive the indentation) start with a `*` should have this `*` aligned with the `*` in the opening of the block comment.

## Noncompliant Code

```kotlin

    /*
          * This comment is not formatted well.
        */
    
```
## Compliant Code

```kotlin

    /*
     * This comment is formatted well.
     */
    
```

[Source](https://detekt.dev/docs/rules/formatting#blockcommentinitialstaralignment)

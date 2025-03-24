# NoSingleLineBlockComment

A single line block comment should be replaced with an EOL comment when possible.

## Noncompliant Code

```kotlin

    /* Some comment */
    val foo = "foo" /* Some comment */
    
```
## Compliant Code

```kotlin

    /*
     * Some comment
     */
    val foo = "foo" // Some comment
    val foo = { /* no-op */ }
    
```

[Source](https://detekt.dev/docs/rules/formatting#nosinglelineblockcomment)

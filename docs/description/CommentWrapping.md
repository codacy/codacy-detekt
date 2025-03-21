# CommentWrapping

A block comment should start and end on a line that does not contain any other element.

## Noncompliant Code

```kotlin
/* Some comment 1 */ val foo1 = "foo1"
val foo2 = "foo" /* Block comment instead of end-of-line comment */
val foo3 = "foo" /* Some comment
                  * with a newline
                  */
```
## Compliant Code

```kotlin
/* Some comment 1 */
val foo1 = "foo1"
val foo2 = "foo" // Some comment
val foo3 = { /* no-op */ }
```

[Source](https://detekt.dev/docs/rules/formatting#commentwrapping)

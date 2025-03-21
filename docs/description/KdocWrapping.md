# KdocWrapping

A KDoc comment should start and end on a line that does not contain any other element.

## Noncompliant Code

```kotlin

    /** Some KDoc comment 1 */ val foo1 = "foo1"
    val foo2 = "foo2" /** Some KDoc comment
                       * with a newline
                       */
    
```
## Compliant Code

```kotlin

    /** Some KDoc comment 1 */
    val foo1 = "foo1"
    
```

[Source](https://detekt.dev/docs/rules/formatting#kdocwrapping)

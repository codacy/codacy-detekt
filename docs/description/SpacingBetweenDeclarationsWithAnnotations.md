# SpacingBetweenDeclarationsWithAnnotations

Declarations with annotations should be separated by a blank line.

## Noncompliant Code

```kotlin

    fun a()
    @Bar
    fun b()
    
```
## Compliant Code

```kotlin

    fun a()

    @Bar
    fun b()
    
```

[Source](https://detekt.dev/docs/rules/formatting#spacingbetweendeclarationswithannotations)

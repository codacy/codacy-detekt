# SpacingAroundCurly

Consistent spacing around curly braces.

## Noncompliant Code

```kotlin
val foo = if (true){0}else{1}
```
## Compliant Code

```kotlin
val foo = if (true) { 0 } else { 1 }
```

[Source](https://detekt.dev/docs/rules/formatting#spacingaroundcurly)

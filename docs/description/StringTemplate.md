# StringTemplate

Consistent string templates (`$v` instead of `${v}`, `${p.v}` instead of `${p.v.toString()}`)

## Noncompliant Code

```kotlin

    val foo = "${foo} hello"
    
```
## Compliant Code

```kotlin

    val foo = "$foo hello"
    
```

[Source](https://detekt.dev/docs/rules/formatting#stringtemplate)

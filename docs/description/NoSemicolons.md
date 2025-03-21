# NoSemicolons

No semicolons (unless used to separate multiple statements on the same line).

## Noncompliant Code

```kotlin

    fun foo() {
        ;
        bar()
        ;

        bar()

        ;
    }
    
```
## Compliant Code

```kotlin

    fun foo() {
        bar()

        bar()
    }
    
```

[Source](https://detekt.dev/docs/rules/formatting#nosemicolons)

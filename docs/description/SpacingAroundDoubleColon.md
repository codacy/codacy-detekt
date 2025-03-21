# SpacingAroundDoubleColon

No spaces around `::`.

## Noncompliant Code

```kotlin

    val foo1 = Foo ::class
    val foo2 = Foo:: class
    val foo3 = Foo :: class
    val foo4 = Foo::
        class
    
```
## Compliant Code

```kotlin

    val foo = Foo::class
    
```

[Source](https://detekt.dev/docs/rules/formatting#spacingarounddoublecolon)

# NoBlankLineInList

Disallow blank lines to be used in lists before the first element, between elements, and after the last element.

*Super type*

## Noncompliant Code

```kotlin

    class FooBar:

        Foo,

        Bar

    {
        // body
    }
    
```
## Compliant Code

```kotlin

    class FooBar:
        Foo,
        Bar {
        // body
    }
    
```

[Source](https://detekt.dev/docs/rules/formatting#noblanklineinlist)

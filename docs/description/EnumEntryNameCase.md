# EnumEntryNameCase

Enum entry names should be uppercase underscore-separated or upper camel-case separated.

## Noncompliant Code

```kotlin

    enum class Bar {
        foo,
        bAr,
        Foo_Bar,
    }
    
```
## Compliant Code

```kotlin

    enum class Bar {
        FOO,
        Foo,
        FOO_BAR,
        FooBar
    }
    
```

[Source](https://detekt.dev/docs/rules/formatting#enumentrynamecase)

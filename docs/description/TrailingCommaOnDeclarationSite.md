# TrailingCommaOnDeclarationSite

Consistent removal (default) or adding of trailing commas on declaration site.

!!! important
    KtLint uses the IntelliJ IDEA `.editorconfig` property `ij_kotlin_allow_trailing_comma` to configure the rule. When this property is enabled, KtLint *enforces* the usage of the trailing comma at declaration site while IntelliJ IDEA default formatter only *allows* to use the trailing comma but leaves it to the developer's discretion to actually use it (or not). KtLint values *consistent* formatting more than a per-situation decision.

## Noncompliant Code

```kotlin

    class FooWrapper(val foo = Foo(
        a = 3,
        b = 4,
    ),) // it's weird to insert "," between unwrapped (continued) parenthesis
    
```
## Compliant Code

```kotlin

    class FooWrapper(
        val foo = Foo(
            a = 3,
            b = 4,
        ),
    )
    
```

[Source](https://detekt.dev/docs/rules/formatting#trailingcommaondeclarationsite)

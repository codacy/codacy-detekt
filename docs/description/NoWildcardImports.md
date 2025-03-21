# NoWildcardImports

No wildcard imports except imports listed in `.editorconfig` property `ij_kotlin_packages_to_use_import_on_demand`.

## Noncompliant Code

```kotlin

    import foobar.*
    
```
## Compliant Code

```kotlin

    import foobar.Bar
    import foobar.Foo
    
```

[Source](https://detekt.dev/docs/rules/formatting#nowildcardimports)

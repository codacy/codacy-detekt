# PackageName

Validates that the package name matches the regular expression `[a-z][a-zA-Z\d]*(\.[a-z][a-zA-Z\d]*)*`.

## Noncompliant Code

```kotlin

    package Foo
    package foo.Foo
    package `foo bar`
    package foo.`foo bar`
    
```
## Compliant Code

```kotlin

    package foo
    package foo.bar
    
```

[Source](https://detekt.dev/docs/rules/formatting#packagename)

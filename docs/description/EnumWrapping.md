# EnumWrapping

An enum should be a single line, or each enum entry has to be placed on a separate line. In case the enumeration contains enum entries and declarations those are to be separated by a blank line.

## Noncompliant Code

```kotlin
enum class Foo {
    A,
    B, C,
    D
}

enum class Foo {
    A;
    fun foo() = "foo"
}
```
## Compliant Code

```kotlin
enum class Foo { A, B, C, D }

enum class Foo {
    A,
    B,
    C,
    D,
    ;

    fun foo() = "foo"
}
```

[Source](https://detekt.dev/docs/rules/formatting#enumwrapping)

# NoEmptyFirstLineInClassBody

Detect blank lines at start of a class body.

## Noncompliant Code

```kotlin

    class Foo {

        val foo = "foo"
    }
    
```
## Compliant Code

```kotlin

    class Foo {
        val foo = "foo"
    }
    
```

[Source](https://detekt.dev/docs/rules/formatting#noemptyfirstlineinclassbody)

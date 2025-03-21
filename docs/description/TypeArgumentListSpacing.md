# TypeArgumentListSpacing

Spacing before and after the angle brackets of a type argument list.

## Noncompliant Code

```kotlin

    val res = ArrayList < LintError > ()
    class B<T> : A< T >() {
        override fun x() = super< A >.x()
    }
    
```
## Compliant Code

```kotlin

    val res = ArrayList<LintError>()
    class B<T> : A<T>() {
        override fun x() = super<A>.x()
    }
    
```

[Source](https://detekt.dev/docs/rules/formatting#typeargumentlistspacing)

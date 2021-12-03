# RedundantVisibilityModifierRule

This rule checks for redundant visibility modifiers.

One exemption is the
[explicit API mode](https://kotlinlang.org/docs/whatsnew14.html#explicit-api-mode-for-library-authors)
In this mode, the visibility modifier should be defined explicitly even if it is public.
Hence, the rule ignores the visibility modifiers in explicit API mode.

## Noncompliant Code

```kotlin
public interface Foo { // public per default

    public fun bar() // public per default
}
```
## Compliant Code

```kotlin
interface Foo {

    fun bar()
}
```

[Source](https://arturbosch.github.io/detekt/style.html#redundantvisibilitymodifierrule)

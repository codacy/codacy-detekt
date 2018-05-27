# RedundantVisibilityModifierRule

This rule checks for redundant visibility modifiers.

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

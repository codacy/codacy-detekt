# ModifierListSpacing

Consistent spacing between modifiers in and after the last modifier in a modifier list.

## Noncompliant Code

```kotlin

    abstract  class Foo {
        protected  abstract  suspend  fun execute()
    }
    abstract
    class Foo {
        protected
        abstract
        suspend
        fun execute()
    }
    
```
## Compliant Code

```kotlin

    abstract class Foo {
        protected abstract suspend fun execute()
    }
    
```

[Source](https://detekt.dev/docs/rules/formatting#modifierlistspacing)

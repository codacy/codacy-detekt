# ModifierOrdering

Consistent order of modifiers

## Noncompliant Code

```kotlin

    abstract class A {
        open protected val v = ""
        open suspend internal fun f(v: Any): Any = ""
        lateinit protected var lv: String
    }
    
```
## Compliant Code

```kotlin

    abstract class A {
        protected open val v = ""
        internal open suspend fun f(v: Any): Any = ""
        protected lateinit var lv: String
    }
    
```

[Source](https://detekt.dev/docs/rules/formatting#modifierordering)

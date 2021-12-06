# UtilityClassWithPublicConstructor

A class which only contains utility variables and functions with no concrete implementation can be refactored
into an `object` or a class with a non-public constructor.
Furthermore, this rule reports utility classes which are not final.

## Noncompliant Code

```kotlin
class UtilityClassViolation {

    // public constructor here
    constructor() {
        // ...
    }

    companion object {
        val i = 0
    }
}

open class UtilityClassViolation private constructor() {

    // ...
}
```
## Compliant Code

```kotlin
class UtilityClass {

    private constructor() {
        // ...
    }

    companion object {
        val i = 0
    }
}
object UtilityClass {

    val i = 0
}
```

[Source](https://arturbosch.github.io/detekt/style.html#utilityclasswithpublicconstructor)

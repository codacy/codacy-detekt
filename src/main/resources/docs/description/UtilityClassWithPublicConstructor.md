# UtilityClassWithPublicConstructor

A class which only contains utility functions and no concrete implementation can be refactored into an `object`.

## Noncompliant Code

```kotlin
class UtilityClass {

    // public constructor here
    constructor() {
        // ...
    }

    companion object {
        val i = 0
    }
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
```

[Source](https://arturbosch.github.io/detekt/style.html#utilityclasswithpublicconstructor)

# UnnecessaryAnnotationUseSiteTarget

This rule inspects the use of the Annotation use-site Target. In case that the use-site Target is not needed it can
be removed. For more information check the kotlin documentation:
[Annotation use-site targets](https://kotlinlang.org/docs/annotations.html#annotation-use-site-targets)

## Noncompliant Code

```kotlin
@property:Inject private val foo: String = "bar" // violation: unnecessary @property:

class Module(@param:Inject private val foo: String) // violation: unnecessary @param:
```
## Compliant Code

```kotlin
class Module(@Inject private val foo: String)
```

[Source](https://arturbosch.github.io/detekt/style.html#unnecessaryannotationusesitetarget)

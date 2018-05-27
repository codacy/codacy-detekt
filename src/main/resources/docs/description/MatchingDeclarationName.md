# MatchingDeclarationName

"If a Kotlin file contains a single non-private class (potentially with related top-level declarations),
its name should be the same as the name of the class, with the .kt extension appended.
If a file contains multiple classes, or only top-level declarations,
choose a name describing what the file contains, and name the file accordingly.
Use camel humps with an uppercase first letter (e.g. ProcessDeclarations.kt).

The name of the file should describe what the code in the file does.
Therefore, you should avoid using meaningless words such as "Util" in file names." - Official Kotlin Style Guide

More information at: http://kotlinlang.org/docs/reference/coding-conventions.html

## Noncompliant Code

```kotlin
class Foo // FooUtils.kt

fun Bar.toFoo(): Foo = ...
fun Foo.toBar(): Bar = ...
```
## Compliant Code

```kotlin
class Foo { // Foo.kt
    fun stuff() = 42
}

fun Bar.toFoo(): Foo = ...
```

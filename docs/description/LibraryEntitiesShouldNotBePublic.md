# LibraryEntitiesShouldNotBePublic

Library typealias and classes should be internal or private.

## Noncompliant Code

```kotlin
// code from a library
class A
```
## Compliant Code

```kotlin
// code from a library
internal class A
```

[Source](https://arturbosch.github.io/detekt/libraries.html#libraryentitiesshouldnotbepublic)

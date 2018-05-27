# WildcardImport

Wildcard imports should be replaced with imports using fully qualified class names. This helps increase clarity of
which classes are imported and helps prevent naming conflicts.

Library updates can introduce naming clashes with your own classes which might result in compilation errors.

## Noncompliant Code

```kotlin
package test

import io.gitlab.arturbosch.detekt.*

class DetektElements {
    val element1 = DetektElement1()
    val element2 = DetektElement2()
}
```
## Compliant Code

```kotlin
package test

import io.gitlab.arturbosch.detekt.DetektElement1
import io.gitlab.arturbosch.detekt.DetektElement2

class DetektElements {
    val element1 = DetektElement1()
    val element2 = DetektElement2()
}
```

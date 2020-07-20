# SpacingBetweenPackageAndImports

This rule verifies spacing between package and import statements as well as between import statements and class
declarations.

## Noncompliant Code

```kotlin
package foo
import a.b
class Bar { }
```
## Compliant Code

```kotlin
package foo

import a.b

class Bar { }
```

[Source](https://arturbosch.github.io/detekt/style.html#spacingbetweenpackageandimports)

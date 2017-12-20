There should be exactly one blank line after the package and import declaration.

```kotlin
//Bad:

package foo.bar
import foo.*

//Good:

package foo.bar

import foo.*
```

[Source](https://github.com/arturbosch/detekt/)
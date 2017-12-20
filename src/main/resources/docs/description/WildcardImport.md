Explicit imports clearly document what external classes a class is directly using, provided that you don't leave redundant imports in your code.

Explicit imports avoid problems with name collisions arising when you import two packages that contain classes with the same class name.
```kotlin
//Bad:

import com.foo.*

//Good:

import com.foo.bar

```

[Source](https://stackoverflow.com/questions/7128348/performance-difference-between-a-wild-card-import-and-the-required-class-import)
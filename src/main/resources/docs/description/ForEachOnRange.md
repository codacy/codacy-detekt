Using the forEach method on ranges has a heavy performance cost. Prefer using simple for loops.

```kotlin
//Bad:

var total = one
(two rangeTo x).forEach{i -> total *= i}

//Good:

var total = one
for (i in two rangeTo x) { total *= i }
```

[Source](https://sites.google.com/a/athaydes.com/renato-athaydes/posts/kotlinshiddencosts-benchmarks)
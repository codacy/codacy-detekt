# MaxChainedCallsOnSameLine

Limits the number of chained calls which can be placed on a single line.

## Noncompliant Code

```kotlin
a().b().c().d().e().f()
```
## Compliant Code

```kotlin
a().b().c()
.d().e().f()
```

[Source](https://arturbosch.github.io/detekt/style.html#maxchainedcallsonsameline)

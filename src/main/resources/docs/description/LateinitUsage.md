# LateinitUsage

Turn on this rule to flag usages of the lateinit modifier.

Using lateinit for property initialization can be error prone and the actual initialization is not
guaranteed. Try using constructor injection or delegation to initialize properties.

## Noncompliant Code

```kotlin
class Foo {
    @JvmField lateinit var i1: Int
    @JvmField @SinceKotlin("1.0.0") lateinit var i2: Int
}
```

[Source](https://arturbosch.github.io/detekt/potential-bugs.html#lateinitusage)

# LateinitUsage

Reports usages of the lateinit modifier.

Using lateinit for property initialization can be error-prone and the actual initialization is not
guaranteed. Try using constructor injection or delegation to initialize properties.

## Noncompliant Code

```kotlin
class Foo {
    private lateinit var i1: Int
    lateinit var i2: Int
}
```

[Source](https://detekt.dev/docs/rules/potential-bugs#lateinitusage)

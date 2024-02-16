# ObjectLiteralToLambda

An anonymous object that does nothing other than the implementation of a single method
can be used as a lambda.

See [SAM conversions](https://kotlinlang.org/docs/java-interop.html#sam-conversions),
[Functional (SAM) interfaces](https://kotlinlang.org/docs/fun-interfaces.html)

## Noncompliant Code

```kotlin
object : Foo {
    override fun bar() {
    }
}
```
## Compliant Code

```kotlin
Foo {
}
```

[Source](https://detekt.dev/docs/rules/style#objectliteraltolambda)

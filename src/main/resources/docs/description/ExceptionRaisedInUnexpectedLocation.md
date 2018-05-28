# ExceptionRaisedInUnexpectedLocation

This rule allows to define functions which should never throw an exception. If a function exists that does throw
an exception it will be reported. By default this rule is checking for `toString`, `hashCode, `equals` and
`finalize`. This rule is configurable via the `methodNames` configuration to change the list of functions which
should not throw any exceptions.

## Noncompliant Code

```kotlin
class Foo {

    override fun toString(): String {
        throw IllegalStateException() // exception should not be thrown here
    }
}
```

[Source](https://arturbosch.github.io/detekt/exceptions.html#exceptionraisedinunexpectedlocation)

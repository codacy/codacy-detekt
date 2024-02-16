# ObjectExtendsThrowable

This rule reports all `objects` including `companion objects` that extend any type of
`Throwable`. Throwable instances are not intended for reuse as they are stateful and contain
mutable information about a specific exception or error. Hence, global singleton `Throwables`
should be avoided.

See https://kotlinlang.org/docs/object-declarations.html#object-declarations-overview
See https://kotlinlang.org/docs/object-declarations.html#companion-objects

## Noncompliant Code

```kotlin
object InvalidCredentialsException : Throwable()

object BanException : Exception()

object AuthException : RuntimeException()
```
## Compliant Code

```kotlin
class InvalidCredentialsException : Throwable()

class BanException : Exception()

class AuthException : RuntimeException()
```

[Source](https://detekt.dev/docs/rules/exceptions#objectextendsthrowable)

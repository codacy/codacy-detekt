# ContextReceiverMapping

Wraps the content receiver list to a separate line regardless of maximum line length. If the maximum line length is configured and is exceeded, wrap the context receivers and if needed its projection types to separate lines.

## Noncompliant Code

```kotlin
// Should be wrapped regardless of whether max line length is set
context(Foo) fun fooBar()

// Should be wrapped when the entire context receiver list does not
// fit on a single line
context(Fooooooooooooooooooo1, Foooooooooooooooooooooooooooooo2)
fun fooBar()

// Should be wrapped when the entire context receiver list does not
// fit on a single line. Also, it should wrap each of it projection
// type in case a context receiver does not fit on a single line 
// after it has been wrapped.
context(Foooooooooooooooo<Foo, Bar>)
fun fooBar()
```
## Compliant Code

```kotlin
// ALways wrap regardless of whether max line length is set
context(Foo)
fun fooBar()

// Wrap each context receiver to a separate line when the
// entire context receiver list does not fit on a single line
context(
    Fooooooooooooooooooo1,
    Foooooooooooooooooooooooooooooo2
)
fun fooBar()

// Wrap each context receiver to a separate line when the
// entire context receiver list does not fit on a single line.
// Also, wrap each of it projection types in case a context
// receiver does not fit on a single line after it has been
// wrapped.
context(
    Foooooooooooooooo<
        Foo,
        Bar
        >
)
fun fooBar()
```

[Source](https://detekt.dev/docs/rules/formatting#contextreceivermapping)

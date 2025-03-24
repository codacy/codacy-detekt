# DiscouragedCommentLocation

Detect discouraged comment locations (no autocorrect).

!!! note
    Kotlin allows comments to be placed almost everywhere. As this can lead to code which is hard to read, most of them will never be used in practice. Ideally each rule takes comments at all possible locations into account. Sometimes this is really hard and not worth the effort. By explicitly forbidding such comment locations, the development of those rules becomes a bit easier.

## Noncompliant Code

```kotlin

    fun <T> /* some comment */ foo(t: T) = "some-result"

    fun foo() {
        if (true)
            // some comment
            bar()
    }
    
```

[Source](https://detekt.dev/docs/rules/formatting#discouragedcommentlocation)

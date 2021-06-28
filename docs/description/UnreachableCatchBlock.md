# UnreachableCatchBlock

Reports unreachable catch blocks.
Catch blocks can be unreachable if the exception has already been caught in the block above.

## Noncompliant Code

```kotlin
fun test() {
    try {
        foo()
    } catch (t: Throwable) {
        bar()
    } catch (e: Exception) {
        // Unreachable
        baz()
    }
}
```
## Compliant Code

```kotlin
fun test() {
    try {
        foo()
    } catch (e: Exception) {
        baz()
    } catch (t: Throwable) {
        bar()
    }
}
```

[Source](https://arturbosch.github.io/detekt/potential-bugs.html#unreachablecatchblock)

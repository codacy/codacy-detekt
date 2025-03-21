# TryCatchFinallySpacing

Enforce consistent spacing in .

## Noncompliant Code

```kotlin
fun foo() =
    try {
        // do something
    } catch (exception: Exception) {
        // handle exception
    } finally {
        // clean up
    }
```
## Compliant Code

```kotlin
try { .. } catch { .. } finally { .. }
```

[Source](https://detekt.dev/docs/rules/formatting#trycatchfinallyspacing)

# TryCatchFinallySpacing

Enforce consistent spacing in `try { .. } catch { .. } finally { .. }`.

## Noncompliant Code

```kotlin

    fun foo1() = try { /* ... */ } catch (exception: Exception) { /* ... */ } finally { /* ... */ }
    fun foo2() = 
        try {
            // do something
        }
        catch (exception: Exception) {
            // handle exception
        }
        finally {
            // clean up
        }
    
```
## Compliant Code

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

[Source](https://detekt.dev/docs/rules/formatting#trycatchfinallyspacing)

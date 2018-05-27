# IteratorHasNextCallsNextMethod

Verifies implementations of the Iterator interface.
The hasNext() method of an Iterator implementation should not have any side effects.
This rule reports implementations that call the next() method of the Iterator inside the hasNext() method.

## Noncompliant Code

```kotlin
class MyIterator : Iterator<String> {

    override fun hasNext(): Boolean {
        return next() != null
    }
}
```

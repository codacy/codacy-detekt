# IteratorNotThrowingNoSuchElementException

Reports implementations of the `Iterator` interface which do not throw a NoSuchElementException in the
implementation of the next() method. When there are no more elements to return an Iterator should throw a
NoSuchElementException.

See: https://docs.oracle.com/javase/7/docs/api/java/util/Iterator.html#next()

## Noncompliant Code

```kotlin
class MyIterator : Iterator<String> {

    override fun next(): String {
        return ""
    }
}
```
## Compliant Code

```kotlin
class MyIterator : Iterator<String> {

    override fun next(): String {
        if (!this.hasNext()) {
            throw NoSuchElementException()
        }
        // ...
    }
}
```

[Source](https://detekt.dev/docs/rules/potential-bugs#iteratornotthrowingnosuchelementexception)

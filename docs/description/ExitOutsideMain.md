# ExitOutsideMain

Flags use of System.exit() and Kotlin's exitProcess() when used outside of the `main` function. This makes code more
difficult to test, causes unexpected behaviour on Android, and is a poor way to signal a failure in the program. In
almost all cases it is more appropriate to throw an exception.

## Noncompliant Code

```kotlin
fun randomFunction() {
    val result = doWork()
    if (result == FAILURE) {
        exitProcess(2)
    } else {
        exitProcess(0)
    }
}
```
## Compliant Code

```kotlin
fun main() {
    val result = doWork()
    if (result == FAILURE) {
        exitProcess(2)
    } else {
        exitProcess(0)
    }
}
```

[Source](https://arturbosch.github.io/detekt/potential-bugs.html#exitoutsidemain)

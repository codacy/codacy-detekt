# ExplicitGarbageCollectionCall

Reports all calls to explicitly trigger the Garbage Collector.
Code should work independently of the garbage collector and should not require the GC to be triggered in certain
points in time.

## Noncompliant Code

```kotlin
System.gc()
Runtime.getRuntime().gc()
System.runFinalization()
```

[Source](https://detekt.github.io/detekt/potential-bugs.html#explicitgarbagecollectioncall)

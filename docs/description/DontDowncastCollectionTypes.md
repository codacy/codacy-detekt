# DontDowncastCollectionTypes

Down-casting immutable types from kotlin.collections should be discouraged.
The result of the downcast is platform specific and can lead to unexpected crashes.
Prefer to use instead the `toMutable<Type>()` functions.

## Noncompliant Code

```kotlin
val list : List<Int> = getAList()
if (list is MutableList) {
    list.add(42)
}

(list as MutableList).add(42)
```
## Compliant Code

```kotlin
val list : List<Int> = getAList()
list.toMutableList().add(42)
```

[Source](https://detekt.dev/docs/rules/potential-bugs#dontdowncastcollectiontypes)

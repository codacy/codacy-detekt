# ExplicitCollectionElementAccessMethod

In Kotlin functions `get` or `set` can be replaced with the shorter operator — `[]`,
see https://kotlinlang.org/docs/reference/operator-overloading.html#indexed.
Prefer the usage of the indexed access operator `[]` for map or list element access or insert methods.

## Noncompliant Code

```kotlin
val map = Map<String, String>()
map.put("key", "value")
val value = map.get("key")
```
## Compliant Code

```kotlin
val map = Map<String, String>()
map["key"] = "value"
val value = map["key"]
```

[Source](https://arturbosch.github.io/detekt/style.html#explicitcollectionelementaccessmethod)

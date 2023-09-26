# ExplicitCollectionElementAccessMethod

In Kotlin functions `get` or `set` can be replaced with the shorter operator — `[]`,
see [Indexed access operator](https://kotlinlang.org/docs/operator-overloading.html#indexed-access-operator).
Prefer the usage of the indexed access operator `[]` for map or list element access or insert methods.

## Noncompliant Code

```kotlin
val map = mutableMapOf<String, String>()
map.put("key", "value")
val value = map.get("key")
```
## Compliant Code

```kotlin
val map = mutableMapOf<String, String>()
map["key"] = "value"
val value = map["key"]
```

[Source](https://detekt.github.io/detekt/style.html#explicitcollectionelementaccessmethod)

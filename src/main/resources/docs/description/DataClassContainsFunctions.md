# DataClassContainsFunctions

This rule reports functions inside data classes which have not been whitelisted as a conversion function.

Data classes should mainly be used to store data. This rule assumes that they should not contain any extra functions
aside functions that help with converting objects from/to one another.
Data classes will automatically have a generated `equals`, `toString` and `hashCode` function by the compiler.

## Noncompliant Code

```kotlin
data class DataClassWithFunctions(val i: Int) {
    fun foo() { }
}
```

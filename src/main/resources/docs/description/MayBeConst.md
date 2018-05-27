# MayBeConst

This rule identifies and reports properties (`val`) that may be `const val` instead.
Using `const val` can lead to better performance of the resulting bytecode as well as better interoperability with
Java.

## Noncompliant Code

```kotlin
val myConstant = "abc"
```
## Compliant Code

```kotlin
const val MY_CONSTANT = "abc"
```

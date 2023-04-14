# OutdatedDocumentation

This rule will report any class, function or constructor with KDoc that does not match the declaration signature.
If KDoc is not present or does not contain any @param or @property tags, rule violation will not be reported.
By default, both type and value parameters need to be matched and declarations orders must be preserved. You can
turn off these features using configuration options.

## Noncompliant Code

```kotlin
/**
* @param someParam
* @property someProp
*/
class MyClass(otherParam: String, val otherProp: String)

/**
* @param T
* @param someParam
*/
fun <T, S> myFun(someParam: String)
```
## Compliant Code

```kotlin
/**
* @param someParam
* @property someProp
*/
class MyClass(someParam: String, val someProp: String)

/**
* @param T
* @param S
* @param someParam
*/
fun <T, S> myFun(someParam: String)
```

[Source](https://arturbosch.github.io/detekt/comments.html#outdateddocumentation)

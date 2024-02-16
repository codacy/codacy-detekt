# ImplicitUnitReturnType

Functions using expression statements have an implicit return type.
Changing the type of the expression accidentally, changes the functions return type.
This may lead to backward incompatibility.
Use a block statement to make clear this function will never return a value.

## Noncompliant Code

```kotlin
fun errorProneUnit() = println("Hello Unit")
fun errorProneUnitWithParam(param: String) = param.run { println(this) }
fun String.errorProneUnitWithReceiver() = run { println(this) }
```
## Compliant Code

```kotlin
fun blockStatementUnit() {
    // code
}

// explicit Unit is compliant by default; can be configured to enforce block statement
fun safeUnitReturn(): Unit = println("Hello Unit")
```

[Source](https://detekt.dev/docs/rules/potential-bugs#implicitunitreturntype)

# NoSingleLineBlockComment

Enforce naming of property.

## Noncompliant Code

```kotlin
val Foo1 = Foo()
val FooBar1 = "FOO-BAR"

var FOO_1: Foo = Foo()

class Bar {
    const val foo2 = "foo"
    const val fooBar2 = "FOO-BAR"

    val FOO2 = "foo"
    val FOO_BAR_2 = "foo-bar"

    // Incomplete backing property as public property 'elementList1' is missing
    private val _elementList1 = mutableListOf<Element>()

    // Invalid backing property as '_elementList2' is not a private property
    val _elementList2 = mutableListOf<Element>()
    val elementList2: List<Element>
        get() = _elementList2
}
```
## Compliant Code

```kotlin
val FOO_1 = Foo()
val FOO_BAR_1 = "FOO-BAR"

var foo1: Foo = Foo()

class Bar {
    const val FOO_2 = "foo"
    const val FOO_BAR_2 = "FOO-BAR"

    val foo2 = "foo"
    val fooBar2 = "foo-bar"

    // Backing property
    private val _elementList = mutableListOf<Element>()
    val elementList: List<Element>
        get() = _elementList
}
```

[Source](https://detekt.dev/docs/rules/formatting#nosinglelineblockcomment)

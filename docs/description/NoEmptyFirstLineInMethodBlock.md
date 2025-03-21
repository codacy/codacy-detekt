# NoEmptyFirstLineInMethodBlock

Multiple annotations should be on a separate line than the annotated declaration; annotations with parameters should each be on separate lines; annotations should be followed by a space

## Noncompliant Code

```kotlin
// An annotation with parameter(s) is not allowed on same line as annotated construct
@Suppress("Unused") class FooBar {
    @Suppress("Unused") var foo: String
    @Suppress("Unused") fun bar() {}
}
// Multiple annotation on same line as annotated construct are not allowed
@Foo @Bar class FooBar {
    @Foo @Bar var foo: String
    @Foo @Bar fun bar() {}
}
```
## Compliant Code

```kotlin
// A single annotation (without parameters) is allowed on same line as annotated construct
@FunctionalInterface class FooBar {
    @JvmField var foo: String
    @Test fun bar() {}
}
// A class or function parameter may have a single annotation with parameter(s) on the same line
class Foo(@Path("fooId") val fooId: String)
class Bar(
    @NotNull("fooId") val fooId: String,
    @NotNull("bar") bar: String
)
// Multiple annotations (without parameters) are allowed on the same line
@Foo @Bar
class FooBar {
    @Foo @Bar
    var foo: String
    @Foo @Bar
    fun bar() {}
}
// An array of annotations (without parameters) is allowed on same line as annotated construct
@[Foo Bar] class FooBar2 {
    @[Foo Bar] var foo: String
    @[Foo Bar] fun bar() {}
}
```

[Source](https://detekt.dev/docs/rules/formatting#noemptyfirstlineinmethodblock)

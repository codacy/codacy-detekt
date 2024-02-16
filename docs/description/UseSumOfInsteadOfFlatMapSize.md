# UseSumOfInsteadOfFlatMapSize

Turn on this rule to flag `flatMap` and `size/count` calls that can be replaced with a `sumOf` call.

## Noncompliant Code

```kotlin
class Foo(val foo: List<Int>)
list.flatMap { it.foo }.size
list.flatMap { it.foo }.count()
list.flatMap { it.foo }.count { it > 2 }
listOf(listOf(1), listOf(2, 3)).flatten().size
```
## Compliant Code

```kotlin
list.sumOf { it.foo.size }
list.sumOf { it.foo.count() }
list.sumOf { it.foo.count { foo -> foo > 2 } }
listOf(listOf(1), listOf(2, 3)).sumOf { it.size }
```

[Source](https://detekt.dev/docs/rules/style#usesumofinsteadofflatmapsize)

# UseLet

`if` expressions that either check for not-null and return `null` in the false case or check for `null` and returns
`null` in the truthy case are better represented as `?.let {}` blocks.

## Noncompliant Code

```kotlin
if (x != null) { x.transform() } else null
if (x == null) null else y
```
## Compliant Code

```kotlin
x?.let { it.transform() }
x?.let { y }
```

[Source](https://detekt.dev/docs/rules/style#uselet)

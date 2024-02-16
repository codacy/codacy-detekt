# UnnecessaryApply

`apply` expressions are used frequently, but sometimes their usage should be replaced with
an ordinary method/extension function call to reduce visual complexity

## Noncompliant Code

```kotlin
config.apply { version = "1.2" } // can be replaced with `config.version = "1.2"`
config?.apply { environment = "test" } // can be replaced with `config?.environment = "test"`
config?.apply { println(version) } // `apply` can be replaced by `let`
```
## Compliant Code

```kotlin
config.apply {
    version = "1.2"
    environment = "test"
}
```

[Source](https://detekt.dev/docs/rules/style#unnecessaryapply)

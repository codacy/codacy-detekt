# ReplaceSafeCallChainWithRun

Chains of safe calls on non-nullable types are redundant and can be removed by enclosing the redundant safe calls in
a `run {}` block. This improves code coverage and reduces cyclomatic complexity as redundant null checks are removed.

This rule only checks from the end of a chain and works backwards, so it won't recommend inserting run blocks in the
middle of a safe call chain as that is likely to make the code more difficult to understand.

The rule will check for every opportunity to replace a safe call when it sits at the end of a chain, even if there's
only one, as that will still improve code coverage and reduce cyclomatic complexity.

## Noncompliant Code

```kotlin
val x = System.getenv()
    ?.getValue("HOME")
    ?.toLowerCase()
    ?.split("/") ?: emptyList()
```
## Compliant Code

```kotlin
val x = getenv()?.run {
    getValue("HOME")
        .toLowerCase()
        .split("/")
} ?: emptyList()
```

[Source](https://detekt.dev/docs/rules/complexity#replacesafecallchainwithrun)

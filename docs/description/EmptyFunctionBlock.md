# EmptyFunctionBlock

Reports empty functions. Empty blocks of code serve no purpose and should be removed.
This rule will not report functions with the override modifier that have a comment as their only body contents
(e.g., a `// no-op` comment in an unused listener function).

Set the `ignoreOverridden` parameter to `true` to exclude all functions which are overriding other
functions from the superclass or from an interface (i.e., functions declared with the override modifier).


[Source](https://detekt.github.io/detekt/empty-blocks.html#emptyfunctionblock)

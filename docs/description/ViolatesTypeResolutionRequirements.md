# ViolatesTypeResolutionRequirements

If a rule uses the property [BaseRule.bindingContext] should be annotated with `@RequiresTypeResolution`.
And if the rule doesn't use that property it shouldn't be annotated with it.


[Source](https://arturbosch.github.io/detekt/ruleauthors.html#violatestyperesolutionrequirements)

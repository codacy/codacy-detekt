# AbsentOrWrongFileLicense

This rule will report every Kotlin source file which doesn't have the required license header.
The rule validates each Kotlin source and operates in two modes: if `licenseTemplateIsRegex = false` (or missing)
the rule checks whether the input file header starts with the read text from the passed file in the
`licenseTemplateFile` configuration option. If `licenseTemplateIsRegex = true` the rule matches the header with
a regular expression produced from the passed template license file (defined via `licenseTemplateFile` configuration
option).


[Source](https://arturbosch.github.io/detekt/comments.html#absentorwrongfilelicense)

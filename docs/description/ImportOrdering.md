# Detects imports in non default order

_This pattern description was written by a Codacy bot for detekt. Send feedback to ai-patterns@codacy.com_

## Description

See [ktlint docs](https://pinterest.github.io/ktlint/0.50.0/rules/standard/#import-ordering) for documentation.

For defining import layout patterns see the [KtLint Source Code](https://github.com/pinterest/ktlint/blob/a6ca5b2edf95cc70a138a9470cfb6c4fd5d9d3ce/ktlint-ruleset-standard/src/main/kotlin/com/pinterest/ktlint/ruleset/standard/ImportOrderingRule.kt)

**Active by default**: Yes - Since v1.19.0

#### Configuration options:

* ``layout`` (default: ``'*,java.**,javax.**,kotlin.**,^'``) (android default: ``'*'``)

  the import ordering layout 

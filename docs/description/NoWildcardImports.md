# Detects wildcard imports

_This pattern description was written by a Codacy bot for detekt. Send feedback to ai-patterns@codacy.com_

## Description

See [ktlint docs](https://pinterest.github.io/ktlint/0.50.0/rules/standard/#no-wildcard-imports) for documentation.

**Active by default**: Yes - Since v1.0.0

#### Configuration options:

* ``packagesToUseImportOnDemandProperty`` (default: ``'java.util.*,kotlinx.android.synthetic.**'``)

  Defines allowed wildcard imports 

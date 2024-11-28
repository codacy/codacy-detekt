# Reports lines with exceeded length

_This pattern description was written by a Codacy bot for detekt. Send feedback to ai-patterns@codacy.com_

## Description

See [ktlint docs](https://pinterest.github.io/ktlint/0.50.0/rules/standard/#max-line-length) for documentation.

This rules overlaps with [style>MaxLineLength](https://detekt.dev/style.html#maxlinelength)
from the standard rules, make sure to enable just one or keep them aligned. The pro of this rule is that it can
auto-correct the issue.

**Active by default**: Yes - Since v1.0.0

#### Configuration options:

* ``maxLineLength`` (default: ``120``) (android default: ``100``)

  maximum line length

* ``ignoreBackTickedIdentifier`` (default: ``false``)

  ignore back ticked identifier 

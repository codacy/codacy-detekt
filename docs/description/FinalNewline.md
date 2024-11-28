# Detects missing final newlines

_This pattern description was written by a Codacy bot for detekt. Send feedback to ai-patterns@codacy.com_

## Description

See [ktlint docs](https://pinterest.github.io/ktlint/0.50.0/rules/standard/#final-newline) for documentation.

This rules overlaps with [style>NewLineAtEndOfFile](https://detekt.dev/style.html#newlineatendoffile)
from the standard rules, make sure to enable just one. The pro of this rule is that it can auto-correct the issue.

**Active by default**: Yes - Since v1.0.0

#### Configuration options:

* ``insertFinalNewLine`` (default: ``true``)

  report absence or presence of a newline 

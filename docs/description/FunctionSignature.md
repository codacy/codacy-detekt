# Format signature to be single when possible, multiple lines otherwise.

_This pattern description was written by a Codacy bot for detekt. Send feedback to ai-patterns@codacy.com_

## Description

See [ktlint docs](https://pinterest.github.io/ktlint/0.50.0/rules/experimental/#function-signature) for
documentation.

**Active by default**: No

#### Configuration options:

* ``forceMultilineWhenParameterCountGreaterOrEqualThan`` (default: ``2147483647``)

  parameter count means multiline threshold

* ``functionBodyExpressionWrapping`` (default: ``'default'``)

  indentation size

* ``maxLineLength`` (default: ``120``) (android default: ``100``)

  maximum line length

* ``indentSize`` (default: ``4``)

  indentation size 

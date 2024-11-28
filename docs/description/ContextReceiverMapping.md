# Reports mis-indented code

_This pattern description was written by a Codacy bot for detekt. Send feedback to ai-patterns@codacy.com_

## Description

See [ktlint docs](### Linting Error: Content Receiver List Not Wrapped

**Error Description:**
This linting error occurs when the content receiver list in your Kotlin code is not properly wrapped to a new line. Ktlint requires that the content receiver list is always placed on a separate line, regardless of the configured maximum line length. If the maximum line length is exceeded, it is also necessary to wrap the context receivers along with their projection types to new lines.

**How to Fix:**
To resolve this error, ensure that your content receiver list is formatted correctly. Here’s how to do it:

1. **Always Wrap the Content Receiver List:**
   Regardless of whether you have a maximum line length set, the content receiver list should be on a) for documentation.

**Active by default**: No

#### Configuration options:

* ``maxLineLength`` (default: ``120``) (android default: ``100``)

  maximum line length

* ``indentSize`` (default: ``4``)

  indentation size 

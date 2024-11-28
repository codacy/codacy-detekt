# Rule to mandate/forbid trailing commas at declaration sites

_This pattern description was written by a Codacy bot for detekt. Send feedback to ai-patterns@codacy.com_

## Description

See [ktlint docs](https://pinterest.github.io/ktlint/0.50.0/rules/standard/#trailing-comma-on-declaration-site) for documentation.

The default config comes from ktlint and follows these conventions:
- [Kotlin coding convention](https://kotlinlang.org/docs/coding-conventions.html#trailing-commas) recommends
trailing comma encourage the use of trailing commas at the declaration site and
leaves it at your discretion for the call site.
- [Android Kotlin style guide](https://developer.android.com/kotlin/style-guide) does not include
trailing comma usage yet.

**Active by default**: No

#### Configuration options:

* ``useTrailingCommaOnDeclarationSite`` (default: ``true``) (android default: ``false``)

  Defines whether trailing commas are required (true) or forbidden (false) at declaration sites 

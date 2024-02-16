# ForbiddenComment

This rule allows to set a list of comments which are forbidden in the codebase and should only be used during
development. Offending code comments will then be reported.

The regular expressions in `comments` list will have the following behaviors while matching the comments:
* **Each comment will be handled individually.**
    * single line comments are always separate, consecutive lines are not merged.
    * multi line comments are not split up, the regex will be applied to the whole comment.
    * KDoc comments are not split up, the regex will be applied to the whole comment.
* **The following comment delimiters (and indentation before them) are removed** before applying the regex:
    `//`, `// `, `/​*`, `/​* `, `/​**`, `*` aligners, `*​/`, ` *​/`
* **The regex is applied as a multiline regex**,
    see [Anchors](https://www.regular-expressions.info/anchors.html) for more info.
    To match the start and end of each line, use `^` and `$`.
    To match the start and end of the whole comment, use `\A` and `\Z`.
    To turn off multiline, use `(?-m)` at the start of your regex.
* **The regex is applied with dotall semantics**, meaning `.` will match any character including newlines,
    this is to ensure that freeform line-wrapping doesn't mess with simple regexes.
    To turn off this behavior, use `(?-s)` at the start of your regex, or use `[^\r\n]*` instead of `.*`.
* **The regex will be searched using "contains" semantics** not "matches",
    so partial comment matches will flag forbidden comments.
    In practice this means there's no need to start and end the regex with `.*`.

The rule can be configured to add extra comments to the list of forbidden comments, here are some examples:
```yaml
ForbiddenComment:
  comments:
    # Repeat the default configuration if it's still needed.
    - reason: 'Forbidden FIXME todo marker in comment, please fix the problem.'
      value: 'FIXME:'
    - reason: 'Forbidden STOPSHIP todo marker in comment, please address the problem before shipping the code.'
      value: 'STOPSHIP:'
    - reason: 'Forbidden TODO todo marker in comment, please do the changes.'
      value: 'TODO:'
    # Add additional patterns to the list.

    - reason: 'Authors are not recorded in KDoc.'
      value: '@author'

    - reason: 'REVIEW markers are not allowed in production code, only use before PR is merged.'
      value: '^\s*(?i)REVIEW\b'
      # Non-compliant: // REVIEW this code before merging.
      # Compliant: // Preview will show up here.

    - reason: 'Use @androidx.annotation.VisibleForTesting(otherwise = VisibleForTesting.PRIVATE) instead.'
      value: '^private$'
      # Non-compliant: /*private*/fun f() { }

      - reason: 'KDoc tag should have a value.'
        value: '^\s*@(?!suppress|hide)\w+\s*$'
        # Non-compliant: /** ... @see */
    # Compliant: /** ... @throws IOException when there's a network problem */

    - reason: 'include an issue link at the beginning preceded by a space'
      value: 'BUG:(?! https://github\.com/company/repo/issues/\d+).*'
```

By default the commonly used todo markers are forbidden: `TODO:`, `FIXME:` and `STOPSHIP:`.

## Noncompliant Code

```kotlin
val a = "" // TODO: remove please
/**
* FIXME: this is a hack
*/
fun foo() { }
/* STOPSHIP: */
```

[Source](https://detekt.github.io/detekt/style.html#forbiddencomment)

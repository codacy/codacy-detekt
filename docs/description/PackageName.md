# Checks package name is formatted correctly

_This pattern description was written by a Codacy bot for detekt. Send feedback to ai-patterns@codacy.com_

## Description

See [ktlint docs](### Linting Error: Invalid Package Name Format

#### Description
This linting error occurs when the package name in your Kotlin code does not adhere to the required naming convention. The package name must match the regular expression: 

```
[a-z][a-zA-Z\d]*(\.[a-z][a-zA-Z\d]*)*
```

#### What This Means
- **Start with a lowercase letter**: The first character of the package name must be a lowercase letter (a-z).
- **Followed by letters or digits**: After the first character, you can have any combination of lowercase letters, uppercase letters, or digits.
- **Dot notation for sub-packages**: If your package name includes sub-packages,) for
documentation.

**Active by default**: Yes - Since v1.22.0 

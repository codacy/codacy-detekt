# BracesOnIfStatements

This rule detects `if` statements which do not comply with the specified rules.
Keeping braces consistent will improve readability and avoid possible errors.

The available options are:
* `always`: forces braces on all `if` and `else` branches in the whole codebase.
* `consistent`: ensures that braces are consistent within each `if`-`else if`-`else` chain.
    If there's a brace on one of the branches, all branches should have it.
* `necessary`: forces no braces on any `if` and `else` branches in the whole codebase
    except where necessary for multi-statement branches.
* `never`: forces no braces on any `if` and `else` branches in the whole codebase.

Single-line if-statement has no line break (\n):
```kotlin
if (a) b else c
```
Multi-line if-statement has at least one line break (\n):
```kotlin
if (a) b
else c
```

## Noncompliant Code

```kotlin
// singleLine = 'never'
if (a) { b } else { c }

if (a) { b } else c

if (a) b else { c; d }

// multiLine = 'never'
if (a) {
    b
} else {
    c
}

// singleLine = 'always'
if (a) b else c

if (a) { b } else c

// multiLine = 'always'
if (a) {
    b
} else
    c

// singleLine = 'consistent'
if (a) b else { c }
if (a) b else if (c) d else { e }

// multiLine = 'consistent'
if (a)
    b
else {
    c
}

// singleLine = 'necessary'
if (a) { b } else { c; d }

// multiLine = 'necessary'
if (a) {
    b
    c
} else if (d) {
    e
} else {
    f
}
```
## Compliant Code

```kotlin
// singleLine = 'never'
if (a) b else c

// multiLine = 'never'
if (a)
    b
else
    c

// singleLine = 'always'
if (a) { b } else { c }

if (a) { b } else if (c) { d }

// multiLine = 'always'
if (a) {
    b
} else {
    c
}

if (a) {
    b
} else if (c) {
    d
}

// singleLine = 'consistent'
if (a) b else c

if (a) { b } else { c }

if (a) { b } else { c; d }

// multiLine = 'consistent'
if (a) {
    b
} else {
    c
}

if (a) b
else c

// singleLine = 'necessary'
if (a) b else { c; d }

// multiLine = 'necessary'
if (a) {
    b
    c
} else if (d)
    e
else
    f
```

[Source](https://arturbosch.github.io/detekt/style.html#bracesonifstatements)

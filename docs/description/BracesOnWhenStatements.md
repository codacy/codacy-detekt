# BracesOnWhenStatements

This rule detects `when` statements which do not comply with the specified policy.
Keeping braces consistent will improve readability and avoid possible errors.

Single-line `when` statement is:
a `when` where each of the branches are single-line (has no line breaks `\n`).

Multi-line `when` statement is:
a `when` where at least one of the branches is multi-line (has a break line `\n`).

Available options are:
* `never`: forces no braces on any branch.
_Tip_: this is very strict, it will force a simple expression, like a single function call / expression.
Extracting a function for "complex" logic is one way to adhere to this policy.
* `necessary`: forces no braces on any branch except where necessary for multi-statement branches.
* `consistent`: ensures that braces are consistent within `when` statement.
    If there are braces on one of the branches, all branches should have it.
* `always`: forces braces on all branches.

## Noncompliant Code

```kotlin
// singleLine = 'never'
when (a) {
    1 -> { f1() } // Not allowed.
    2 -> f2()
}
// multiLine = 'never'
when (a) {
    1 -> { // Not allowed.
        f1()
    }
    2 -> f2()
}
// singleLine = 'necessary'
when (a) {
    1 -> { f1() } // Unnecessary braces.
    2 -> f2()
}
// multiLine = 'necessary'
when (a) {
    1 -> { // Unnecessary braces.
        f1()
    }
    2 -> f2()
}

// singleLine = 'consistent'
when (a) {
    1 -> { f1() }
    2 -> f2()
}
// multiLine = 'consistent'
when (a) {
    1 ->
        f1() // Missing braces.
    2 -> {
        f2()
        f3()
    }
}

// singleLine = 'always'
when (a) {
    1 -> { f1() }
    2 -> f2() // Missing braces.
}
// multiLine = 'always'
when (a) {
    1 ->
        f1() // Missing braces.
    2 -> {
        f2()
        f3()
    }
}
```
## Compliant Code

```kotlin
// singleLine = 'never'
when (a) {
    1 -> f1()
    2 -> f2()
}
// multiLine = 'never'
when (a) {
    1 ->
        f1()
    2 -> f2()
}
// singleLine = 'necessary'
when (a) {
    1 -> f1()
    2 -> { f2(); f3() } // Necessary braces because of multiple statements.
}
// multiLine = 'necessary'
when (a) {
    1 ->
        f1()
    2 -> { // Necessary braces because of multiple statements.
        f2()
        f3()
    }
}

// singleLine = 'consistent'
when (a) {
    1 -> { f1() }
    2 -> { f2() }
}
when (a) {
    1 -> f1()
    2 -> f2()
}
// multiLine = 'consistent'
when (a) {
    1 -> {
        f1()
    }
    2 -> {
        f2()
        f3()
    }
}

// singleLine = 'always'
when (a) {
    1 -> { f1() }
    2 -> { f2() }
}
// multiLine = 'always'
when (a) {
    1 -> {
        f1()
    }
    2 -> {
        f2()
        f3()
    }
}
```

[Source](https://arturbosch.github.io/detekt/style.html#bracesonwhenstatements)

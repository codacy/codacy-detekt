# UnconditionalJumpStatementInLoop

Reports loops which contain jump statements that jump regardless of any conditions.
This implies that the loop is only executed once and thus could be rewritten without a
loop altogether.

## Noncompliant Code

```kotlin
for (i in 1..2) break
```
## Compliant Code

```kotlin
for (i in 1..2) {
    if (i == 1) break
}
```

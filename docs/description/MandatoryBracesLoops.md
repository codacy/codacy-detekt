# MandatoryBracesLoops

This rule detects multi-line `for` and `while` loops which do not have braces.
Adding braces would improve readability and avoid possible errors.

## Noncompliant Code

```kotlin
for (i in 0..10)
    println(i)

while (true)
    println("Hello, world")

do
    println("Hello, world")
while (true)
```
## Compliant Code

```kotlin
for (i in 0..10) {
    println(i)
}

for (i in 0..10) println(i)

while (true) {
    println("Hello, world")
}

while (true) println("Hello, world")

do {
    println("Hello, world")
} while (true)

do println("Hello, world") while (true)
```

[Source](https://arturbosch.github.io/detekt/style.html#mandatorybracesloops)

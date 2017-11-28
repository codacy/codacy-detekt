If cases are handled in the same way, they should be merged.
Always include the else case.
```kotlin
//Bad:

when (anInput) {
  1 -> doSomethingForCaseOne()
  2 -> doSomethingForCaseOneOrTwo()
  3 -> doSomethingForCaseThree()
}

//Good:

when (anInput) {
  1, 2 -> doSomethingForCaseOneOrTwo()
  3 -> doSomethingForCaseThree()
  else -> println("No case satisfied")
}

```

[Source](https://github.com/raywenderlich/kotlin-style-guide#when-statements)
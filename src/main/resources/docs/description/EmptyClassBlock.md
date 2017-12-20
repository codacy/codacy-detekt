No empty class bodies.
````kotlin
//Bad:

class A {}
interface B {}

//Good:

class A
interface B

````


[Source](https://ktlint.github.io/#rule-empty-class-body)
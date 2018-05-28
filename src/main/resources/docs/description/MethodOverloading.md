# MethodOverloading

This rule reports methods which have many versions of the same method with different parameter overloading.
Method overloading tightly couples these methods together which might make the code harder to understand.

Refactor these methods and try to use optional parameters instead to prevent some of the overloading.


[Source](https://arturbosch.github.io/detekt/complexity.html#methodoverloading)

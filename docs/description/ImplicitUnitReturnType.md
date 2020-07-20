# ImplicitUnitReturnType

Functions using expression statements have an implicit return type.
Changing the type of the expression accidentally, changes the functions return type.
This may lead to backward incompatibility.
Use a block statement to make clear this function will never return a value.


[Source](https://arturbosch.github.io/detekt/potential-bugs.html#implicitunitreturntype)

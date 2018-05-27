# ComplexInterface

Complex interfaces which contain too many functions and/or properties indicate that this interface is handling too
many things at once. Interfaces should follow the single-responsibility principle to also encourage implementations
of this interface to not handle too many things at once.

Large interfaces should be split into smaller interfaces which have a clear responsibility and are easier
to understand and implement.


[Source](https://arturbosch.github.io/detekt/complexity.html#complexinterface)

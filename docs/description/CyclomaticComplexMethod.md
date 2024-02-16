# CyclomaticComplexMethod

Complex methods are hard to understand and read. It might not be obvious what side-effects a complex method has.
Prefer splitting up complex methods into smaller methods that are in turn easier to understand.
Smaller methods can also be named much clearer which leads to improved readability of the code.

This rule uses McCabe's Cyclomatic Complexity (MCC) metric to measure the number of
linearly independent paths through a function's source code (https://www.ndepend.com/docs/code-metrics#CC).
The higher the number of independent paths, the more complex a method is.
Complex methods use too many of the following statements.
Each one of them adds one to the complexity count.

- __Conditional statements__ - `if`, `else if`, `when`
- __Jump statements__ - `continue`, `break`
- __Loops__ - `for`, `while`, `do-while`, `forEach`
- __Operators__ `&&`, `||`, `?:`
- __Exceptions__ - `catch`, `use`
- __Scope Functions__ - `let`, `run`, `with`, `apply`, and `also` ->
[Reference](https://kotlinlang.org/docs/scope-functions.html)


[Source](https://detekt.dev/docs/rules/complexity#cyclomaticcomplexmethod)

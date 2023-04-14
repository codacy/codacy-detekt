# CognitiveComplexMethod

Complex methods are hard to understand and read. It might not be obvious what side-effects a complex method has.
Prefer splitting up complex methods into smaller methods that are in turn easier to understand.
Smaller methods can also be named much clearer which leads to improved readability of the code.

This rule measures and restricts the complexity of the method through the [Cognitive Complexity metric of Sonasource](https://www.sonarsource.com/docs/CognitiveComplexity.pdf).
Which improves McCabe's Cyclomatic Complexity ({@link CyclomaticComplexMethod}) considering the programmer's mental model.

Similar to cyclomatic complexity, it is a mathematical model that increases +1 complexity for flow control statements,
but increases additional complexity when the statements are deeply nested.

The statements that increase the complexity or the nesting level are as follows.
- __Complexity Increments__ - `if`, `when`, `for`, `while`, `do while`, `catch`, `labeled break`, `labeled continue`, `labeled return`, `recursion call`, `&&`, `||`
- __Nesting Level Increments__ - `if`, `when`, `for`, `while`, `do while`, `catch`, `nested function`
- __Additional Complexity Increments by Nesting Level__ - `if`, `when`, `for`, `while`, `do while`, `catch`


[Source](https://arturbosch.github.io/detekt/complexity.html#cognitivecomplexmethod)

# CommentOverPrivateProperty

This rule reports comments and documentation above private properties. This can indicate that the property has a
confusing name or is not in a small enough context to be understood.
Private properties should be named in a self-explanatory way and readers of the code should be able to understand
why the property exists and what purpose it solves without the comment.

Instead of simply removing the comment to solve this issue, prefer renaming the property to a more self-explanatory
name. If this property is inside a bigger class, it makes sense to refactor and split up the class. This can
increase readability and make the documentation obsolete.


[Source](https://arturbosch.github.io/detekt/comments.html#commentoverprivateproperty)

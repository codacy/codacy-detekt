# CommentSpacing

The end of line comment sign `//` should be preceded and followed by exactly a space.

## Noncompliant Code

```kotlin

    //comment
    var debugging = false// comment
    var debugging = false //comment
    var debugging = false//comment
    fun main() {
        System.out.println(//123
            "test"
        )
    }
        //comment
    
```
## Compliant Code

```kotlin

    // comment
    var debugging = false // comment
    var debugging = false // comment
    var debugging = false // comment
    fun main() {
        System.out.println( // 123
            "test"
        )
    }
        // comment
    
```

[Source](https://detekt.dev/docs/rules/formatting#commentspacing)

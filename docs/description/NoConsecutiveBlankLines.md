# NoConsecutiveBlankLines



## Noncompliant Code

```kotlin

    package com.test


    import com.test.util


    val a = "a"


    fun b() {
    }


    fun c()
    
```
## Compliant Code

```kotlin

    package com.test

    import com.test.util

    val a = "a"

    fun b() {
    }

    fun c()
    
```

[Source](https://detekt.dev/docs/rules/formatting#noconsecutiveblanklines)

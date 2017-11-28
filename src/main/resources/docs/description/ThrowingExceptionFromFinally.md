An exception thrown from the `finally` block will replace any exception that was thrown from the `try`,
 and information about the real problem is likely to be lost.
 
 ```kotlin
 //Bad:
 
 try {
     ...
 }
 catch (e: SomeException) {
     // handler
 }
 finally {
     throw FooExeption
 }
 
 ```
 
 [Source](https://stackoverflow.com/questions/31725629/is-throwing-an-exception-inside-a-finally-block-a-performance-issue)
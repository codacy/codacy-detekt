The main purpose of data classes is to hold data.
 This type of class should not have any extra function.
 
 ```kotlin
 //Bad:
 
 data class User (val name: String, val age: Int) {
    override fun toString () : String {
         return "Person(name=$name, age=$age)"
    }
 }
 
 //Good:
 
 data class User (val name: String, val age: Int)

 ```
 
[Source](https://kotlinlang.org/docs/reference/data-classes.html)
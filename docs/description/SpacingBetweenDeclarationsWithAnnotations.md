# Declarations and declarations with annotations should have an empty space between.

_This pattern description was written by a Codacy bot for detekt. Send feedback to ai-patterns@codacy.com_

## Description

See [ktlint docs](https://pinterest.github.io/ktlint/0.50.0/rules/standard/#blank-line-between-declarations-with-annotations) for documentation.

**Error Description:**  
In Kotlin, when you have multiple declarations with annotations, it's important to separate them with a blank line for better readability and adherence to coding standards. This helps to clearly distinguish between different declarations and enhances the overall structure of your code.

**What to Fix:**  
If you see this linting error, it means that you have two or more declarations with annotations that are not separated by a blank line. You need to add an empty line between these declarations.

**Example of Non-Compliant Code:**
```kotlin
fun a() 
@Bar
fun b() 
```

**Corrected Code:**
```kotlin
fun a() 

@)
for documentation.

**Active by default**: Yes - Since v1.22.0 

# StringShouldBeRawString

This rule reports when the string can be converted to Kotlin raw string.
Usage of a raw string is preferred as that avoids the need for escaping strings escape characters like \n, \t, ".
Raw string also allows us to represent multiline string without the need of \n.
Also, see [Kotlin coding convention](https://kotlinlang.org/docs/coding-conventions.html#strings)  for
recommendation on using multiline strings

## Noncompliant Code

```kotlin
val windowJson = "{\n" +
    "  \"window\": {\n" +
    "    \"title\": \"Sample Quantum With AI and ML Widget\",\n" +
    "    \"name\": \"main_window\",\n" +
    "    \"width\": 500,\n" +
    "    \"height\": 500\n" +
    "  }\n" +
    "}"

val patRegex = "/^(\\/[^\\/]+){0,2}\\/?\$/gm\n"
```
## Compliant Code

```kotlin
val windowJson = """
    {
         "window": {
             "title": "Sample Quantum With AI and ML Widget",
             "name": "main_window",
             "width": 500,
             "height": 500
         }
    }
""".trimIndent()

val patRegex = """/^(\/[^\/]+){0,2}\/?$/gm"""
```

[Source](https://arturbosch.github.io/detekt/style.html#stringshouldberawstring)

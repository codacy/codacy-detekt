# Scripts


## Update patterns and description files

1. Run ```sbt console``` on this project root (not inside any folder!) and copy the content of [this file](patterns-description-generator.scala).

2. Still in sbt console call (with the Detekt version number): ```updatePatternsAndDescription("RC4-3")```. 

3. Indent the output and paste it in [patterns](../src/main/resources/docs/patterns.json) and [description](../src/main/resources/docs/description/description.json) files.
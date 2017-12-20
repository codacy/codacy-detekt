The caught exception is swallowed. The original exception could be lost.

```kotlin
//Bad:

try {
  //...
} catch (e: Exception) {}

```

[Source](https://lostechies.com/jimmybogard/2007/04/30/swallowing-exceptions-is-hazardous-to-your-health/)
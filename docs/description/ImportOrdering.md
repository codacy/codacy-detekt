# ImportOrdering

Ensures that imports are ordered consistently (see [Import Layouts](../configuration-ktlint/#import-layouts) for configuration).

## Noncompliant Code

```kotlin

    import com.bar.Bar
    import java.util.concurrent.ConcurrentHashMap
    import org.foo.bar.FooBar
    import com.foo.Foo
    
```
## Compliant Code

```kotlin

    import com.bar.Bar
    import com.foo.Foo
    import org.foo.bar.FooBar
    import java.util.concurrent.ConcurrentHashMap
    
```

[Source](https://detekt.dev/docs/rules/formatting#importordering)

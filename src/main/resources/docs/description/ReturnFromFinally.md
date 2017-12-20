Returning from inside a `finnaly` block will cause exceptions to be lost.

```
try {
	  ...
	  throw BarException()
} finally {
	  return foo;
}
```


[Source](htt`ps://stackoverflow.com/questions/18205493/can-we-use-return-in-finally-block)
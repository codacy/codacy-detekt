//#Patterns: ForEachOnRange
package foo
fun test() {
    //#Warn: ForEachOnRange
  (1..10).forEach {
    println(it)
  }
}
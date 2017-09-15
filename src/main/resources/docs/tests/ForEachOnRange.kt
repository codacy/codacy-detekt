//#Patterns: ForEachOnRange
package foo
fun test() {
    //#Warn: ForEachOnRange
  (a..x).forEach {
    println(it)
  }
}
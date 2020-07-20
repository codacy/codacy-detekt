//#Patterns: ReturnFromFinally
fun x() {
    try {
    } finally {
        //#Warn: ReturnFromFinally
        return 0
    }
}
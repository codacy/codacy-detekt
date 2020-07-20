//#Patterns: RethrowCaughtException
fun x() {
    try {
    } catch (e: IllegalStateException) {
        //#Info: RethrowCaughtException
        throw e
    }
}
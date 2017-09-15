//#Patterns: RethrowCaughtException
fun x() {
    try {
    } catch (e: IllegalStateException) {
        //#Warn: RethrowCaughtException
        throw e
    }
}
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

suspend fun main() {
    val squarePrinter = GlobalScope.launch(Dispatchers.Default) {
        var i = 1
        while (true) {
            println(i++)
        }
    }

    delay(100)
    squarePrinter.cancel()
}
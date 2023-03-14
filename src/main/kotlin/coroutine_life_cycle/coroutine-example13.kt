import kotlinx.coroutines.async
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withTimeout
import java.io.File

fun main() {
    runBlocking {
        val asyncData = async { File("data.txt").readText() }
        try {
            val text = withTimeout(1) { asyncData.await() }
            println("Data loaded: $text")
        } catch (e: Exception) {
            println("Timeout exceeded")
        }
    }
}
import kotlinx.coroutines.newSingleThreadContext
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext

// 중단 가능 루틴의 일부를 한 스레드에서만 실행하고 싶을 때 유용
@Suppress("EXPERIMENTAL_API_USAGE")
fun main() {
    newSingleThreadContext("Worker").use { worker ->
        runBlocking {
            println(Thread.currentThread().name)
            withContext(worker) {
                println(Thread.currentThread().name)
            }
            println(Thread.currentThread().name)
        }
    }
}
import kotlinx.coroutines.async
import kotlinx.coroutines.runBlocking

// 여전히 예외와 함께 중단
// 자식이 실패한 경우에는 부모를 취소시키기 위해 자동으로 예외를 다시 던지기 때문
fun main() {
    runBlocking {
        val deferredA = async {
            throw Exception("Error in task A")
            println("Task A Completed")
        }

        val deferredB = async {
            println("Task B completed")
        }

        try {
            deferredA.await()
            deferredB.await()
        } catch (e: Exception) {
            println("Caught $e")
        }
        println("Root")
    }
}
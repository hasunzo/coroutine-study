import kotlinx.coroutines.Job
import kotlinx.coroutines.job
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() {
    runBlocking {
        val job = coroutineContext[Job.Key]!!
        val jobA = launch { println("This is task A") }
        val jobB = launch { println("This is task B") }

        jobA.join()
        jobB.join()

        println("${job.children.count()} children running")
        println("jobA isCompleted? ${jobA.isCompleted}")
        println("jobA isActive? ${jobA.isActive}")
    }
}
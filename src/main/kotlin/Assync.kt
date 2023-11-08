import kotlinx.coroutines.*
import java.nio.file.Files
import java.nio.file.Paths

suspend fun calculateSumOfNumbersInFilesAssync() = coroutineScope {
    for(i in 1..numberPages) {
        launch(Dispatchers.Default) {
            val fileName = Paths.get("file$i.txt")
            val sum = Files.readAllLines(fileName).sumBy { it.toIntOrNull() ?: 0 }
            sumArray[i - 1] = sum
            println("Сумма чисел в файле $fileName: $sum")
            println()
        }
    }
    val totalSum = sumArray.sum()
    println("Общая сумма чисел из всех файлов: $totalSum")
}

fun main() = runBlocking{
    val time = System.currentTimeMillis()
    calculateSumOfNumbersInFilesAssync()
    println((System.currentTimeMillis() - time).toString() + " millis")
}
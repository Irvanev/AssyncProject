import java.nio.file.Files
import java.nio.file.Paths

fun calculateSumOfNumbersInFilesSingle() {
    for (i in 1..numberPages) {
        val fileName = Paths.get("file$i.txt")
        val sum = Files.readAllLines(fileName).sumBy { it.toIntOrNull() ?: 0 }
        sumArray[i - 1] = sum
        println("Сумма чисел в файле $fileName: $sum")
    }
    println()
    val totalSum = sumArray.sum()
    println("Общая сумма чисел из всех файлов: $totalSum")
}

fun main() {
    val time = System.currentTimeMillis()
    //generateFileSingle()
    calculateSumOfNumbersInFilesSingle()
    println((System.currentTimeMillis() - time).toString() + " millis")
}
package laba2

import java.io.File
import kotlin.random.Random

val numberPages = 30
val numberRows = 1000000
val sumArray = IntArray(numberPages)

fun main() {
    for (i in 1..numberPages) {
        val fileName = "file$i.txt"
        val file = File(fileName)

        file.createNewFile()
        val writer = file.bufferedWriter()

        for (j in 1..numberRows) {
            val randomNumber = Random.nextInt(-100, 101)
            writer.write(randomNumber.toString())
            writer.newLine()
        }
        writer.close()
        println("Создан файл: $fileName")
    }
}
package laba3

import kotlin.math.pow

// Заданная функция F(x)
fun functionF(x: Double): Double {
    return x.pow(2) // Замените на свою функцию
}

// Метод трапеции для аппроксимации интеграла на отрезке [a, b]
fun trapezoidalMethod(a: Double, b: Double, n: Int): Double {
    val h = (b - a) / n
    var result = (functionF(a) + functionF(b)) / 2.0

    for (i in 1 until n) {
        val x = a + i * h
        result += functionF(x)
    }

    result *= h
    return result
}

// Метод деления отрезка пополам с заданной погрешностью
fun integrateByBisection(a: Double, b: Double, epsilon: Double): Double {
    var n = 2
    var integralPrev = trapezoidalMethod(a, b, n)
    var integralCurrent = trapezoidalMethod(a, b, n * 2)

    while (Math.abs(integralCurrent - integralPrev) > epsilon) {
        n *= 2
        integralPrev = integralCurrent
        integralCurrent = trapezoidalMethod(a, b, n * 2)
    }

    return integralCurrent
}

fun main() {
    val a = 0.0 // Начальная точка отрезка
    val b = 1.0 // Конечная точка отрезка
    val epsilon = 0.0001 // Заданная погрешность

    val result = integrateByBisection(a, b, epsilon)
    println("Значение интеграла: $result")
}

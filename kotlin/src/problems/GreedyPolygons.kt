package problems

import kotlin.math.PI
import kotlin.math.tan

fun main() {
    val cases = readLine()!!.toInt()
    (1..cases).forEach { _ ->
        val (n, l, d, g) = readLine()!!.split(" ").map { it.toInt() }
        println((l * l * n) / (4 * tan(PI / n)) + l * d * g * n + PI * d * g * d * g)
    }
}
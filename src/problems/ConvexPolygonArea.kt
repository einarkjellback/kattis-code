package problems

import kotlin.math.abs
import kotlin.math.ceil
import kotlin.math.round

fun main() {
    val cases = readLine()!!.toInt()
    for (c in 1..cases) {
        val polygon = readLine()!!.split(" ").map { it.toInt() }
        val n = polygon[0]
        var area = (polygon[polygon.size - 2] - polygon[1]) * (polygon[2] + polygon[polygon.size - 1])
        for (i in 1 until n * 2 - 1 step 2) {
            area += (polygon[i] - polygon[i + 2]) * (polygon[i + 1] + polygon[i + 3])
        }
        println(area * 0.5)
    }
}
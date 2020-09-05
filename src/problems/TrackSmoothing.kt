package problems

import java.lang.Math.PI
import java.lang.Math.pow
import kotlin.math.sqrt


fun main() {
    val cases = readLine()!!.toInt()
    for (case in 1..cases) {
        val (r, n) = readLine()!!.split(" ").map {it.toInt()}
        val (startX, startY) = readLine()!!.split(" ").map { it.toDouble() }
        var prevX = startX
        var prevY = startY
        var circum = 0.0
        for (p in 0 until n - 1) {
            val (x, y) = readLine()!!.split(" ").map { it.toDouble() }
            circum += sqrt(pow(prevX - x, 2.0) + pow(prevY - y, 2.0))
            prevX = x
            prevY = y
        }
        circum += sqrt(pow(prevX - startX, 2.0) + pow(prevY - startY, 2.0))
        val scaleBy = 1 - 2 * PI  * r / circum
        println(if (0 < scaleBy && scaleBy <= 1) scaleBy else "Not possible")
    }
}
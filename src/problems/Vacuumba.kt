package problems

import kotlin.math.PI
import kotlin.math.cos
import kotlin.math.sin

fun main() {
    val cases = readLine()!!.toInt()
    for (case in 1..cases) {
        var dir = PI / 2
        var x = 0.0
        var y = 0.0
        val segments = readLine()!!.toInt()
        for (s in 1..segments) {
            val (deg, dist) = readLine()!!.split(" ").map { it.toDouble() }
            dir += toRad(deg)
            y += dist * sin(dir)
            x += dist * cos(dir)
        }
        println("$x $y")
    }
}

fun toRad(deg: Double): Double {
    return deg * PI / 180
}


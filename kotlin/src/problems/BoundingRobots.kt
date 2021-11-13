package problems

import java.lang.Math.max
import java.lang.Math.min

fun main() {
    var input = readLine()!!
    while (input != "0 0") {
        val (w, l) = input.split(" ").map {it.toInt()}
        val moves = readLine()!!.toInt()
        var (xActual, yActual, xRobot, yRobot) = Array(4) {0}
        for (i in 1..moves) {
            input = readLine()!!
            val dir = input[0]
            val steps = input.drop(2).toInt()
            when (dir) {
                'd' -> {
                    yRobot -= steps
                    yActual = max(0, yActual - steps)
                }
                'l' -> {
                    xRobot -= steps
                    xActual = max(0, xActual - steps)
                }
                'u' -> {
                    yRobot += steps
                    yActual = min(l - 1, yActual + steps)
                }
                'r' -> {
                    xRobot += steps
                    xActual = min(w - 1, xActual + steps)
                }
            }
        }
        println("Robot thinks $xRobot $yRobot")
        println("Actually at $xActual $yActual\n")
        input = readLine()!!
    }
}
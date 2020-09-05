package problems

import kotlin.math.abs
import kotlin.math.min


fun main() {
    val from = readLine()!!.toInt()
    val to = readLine()!!.toInt()
    val clockwiseDist: Int
    val counterClockwiseDist: Int
    if (from > to) {
        counterClockwiseDist = from - to
        clockwiseDist = 360 - counterClockwiseDist
    } else {
        clockwiseDist = to - from
        counterClockwiseDist = 360 - clockwiseDist
    }
    println(if (clockwiseDist <= counterClockwiseDist) clockwiseDist else -counterClockwiseDist)
}
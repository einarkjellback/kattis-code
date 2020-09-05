package problems

import kotlin.math.pow

fun main() {
    val cases = readLine()!!.toInt()
    for (case in 1..cases) {
        val k = readLine()!!.toInt()
        println((2.0.pow(k) - 1).toInt())
    }
}
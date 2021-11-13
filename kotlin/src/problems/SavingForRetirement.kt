package problems

import kotlin.math.ceil

fun main() {
    val (b, bR, bS, a, aS) = readLine()!!.split(" ").map { it.toInt() }
    print(ceil((bR - b) * bS / aS + a + 0.000000001).toInt())
}
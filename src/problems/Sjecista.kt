package problems

import kotlin.math.min

fun main() {
    val n = readLine()!!.toInt()
    var acc = 0
    for (i in min(0, n - 4)..n - 4) {
        acc += (i + 1) * (n - 3 - i) * (n - 2 - i)
    }
    print((0.5 * acc).toInt())
}
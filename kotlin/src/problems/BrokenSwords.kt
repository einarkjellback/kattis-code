package problems

import kotlin.math.max
import kotlin.math.min

fun main() {
    val nBroken = readLine()!!.toInt()
    var tb = nBroken * 2
    var lr = nBroken * 2
    for (i in 1..nBroken) {
        val (t, b, l, r) = readLine()!!
            .split("")
            .drop(1)
            .dropLast(1)
            .map { it.toInt() }
        tb -= t + b
        lr -= l + r
    }
    val q = min(tb, lr) / 2
    val temp = tb - q * 2
    lr -= q * 2
    print("$q $temp $lr")
}
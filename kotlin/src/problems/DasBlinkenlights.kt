package problems

import kotlin.math.max
import kotlin.math.min

fun main() {
    val (p, q, s) = readLine()!!.split(" ").map { it.toInt() }
    print(if (lcm(p, q) <= s) "yes" else "no")
}

fun lcm(p: Int, q: Int): Int {
    return p * q / gcd(max(p, q), min(p, q))
}

fun gcd(p: Int, q: Int): Int {
    var a = p
    var b = q
    while (b > 0) {
        val r = a - (a / b) * b
        a = b
        b = r
    }
    return a
}

package problems

import java.math.BigDecimal
import java.math.RoundingMode

fun main() {
    val n = readLine()!!.toInt()
    var e = BigDecimal.ONE
    var facAcc = BigDecimal.ONE
    for (i in 1..n) {
        facAcc = facAcc.multiply(BigDecimal(i))
        e = e.add(BigDecimal.ONE.divide(facAcc, 13, RoundingMode.HALF_UP))
    }
    println(e)
}
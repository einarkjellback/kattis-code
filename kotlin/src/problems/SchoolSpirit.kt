package problems

import kotlin.math.pow

fun main() {
    val n = readLine()!!.toInt()
    val scores = (1..n).map { readLine()!!.toInt() }
    println(getScore(scores))
    var accScore = 0.0
    for (i in 0 until n) {
        accScore += getScore(scores.take(i) + scores.drop(i + 1))
    }
    println(accScore / n)
}

fun getScore(scores: List<Int>): Double {
    return scores
        .mapIndexed {i, s -> 0.2 * s * 0.8.pow(i) }
        .sum()
}

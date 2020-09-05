package problems

import kotlin.math.floor

fun main() {
    val dogs = readLine()!!.split(" ").map {it.toDouble()}
    val arrivals = readLine()!!.split(" ").map {it.toDouble()}
    for (arrival in arrivals) {
        var acc = 0
        for (dog in intArrayOf(0, 2)) {
            val attackPeriod = dogs[dog]
            val restPeriod = dogs[dog + 1]
            val period = attackPeriod + restPeriod
            val lowerBound = floor((arrival - 1) / period) * period
            val upperBound = lowerBound + attackPeriod
            if (arrival in lowerBound..upperBound) acc += 1
        }
        when (acc) {
            0 -> println("none")
            1 -> println("one")
            else -> println("both")
        }
    }
}
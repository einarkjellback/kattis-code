package problems

import kotlin.math.max

fun main() {
    val str = readLine()!!
    var lettersToRemove = 0
    val letterCounter = mutableMapOf<Char, Int>()
    for (c in str) {
        letterCounter.putIfAbsent(c, 0)
        val value = letterCounter.getValue(c) + 1
        letterCounter[c] = value
        if (value % 2 == 0) lettersToRemove -= 1
        else lettersToRemove += 1
    }
    lettersToRemove = max(0, lettersToRemove - 1)
    print(lettersToRemove)
}
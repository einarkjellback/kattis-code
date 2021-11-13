package problems

import kotlin.math.min

fun main() {
    val msg = readLine()!!
    var compressedSize = msg.length
    for (length in 1..msg.length) {
        for (lo in 0..msg.length - length) {
            val substring = msg.slice(lo until lo + length)
            val compressedMsg = msg.replace(substring, "")
            val n = (msg.length - compressedMsg.length) / substring.length
            compressedSize = min(compressedSize, compressedMsg.length + n + substring.length)
        }
    }
    print(compressedSize)
}
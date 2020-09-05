package problems

fun main() {
    val n = readLine()!!.toInt()
    val digits = readLine()!!
        .split(" ")
        .map { it.toInt() }
        .sortedDescending()
    var acc = 0
    for (i in 0 until n step 2) {
        acc += digits[i]
    }
    print(acc)
    acc = 0
    for (i in 1 until n step 2) {
        acc += digits[i]
    }
    print(" $acc")
}
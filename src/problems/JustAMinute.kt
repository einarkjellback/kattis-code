package problems

fun main() {
    val n = readLine()!!.toInt()
    var sumSecs = 0
    var sumMin = 0
    for (i in 1..n) {
        val pair = readLine()!!.split(" ").map { it.toInt() }
        sumMin += pair[0]
        sumSecs += pair[1]
    }
    val slMin = sumSecs / (60.0 * sumMin)
    print(if (slMin <= 1) "measurement error" else slMin)
}
package problems

fun main() {
    val n = readLine()!!.toInt()
    var missingNumbersFlag = false
    var expCurrent = 1
    for (i in 1..n) {
        val actCurrent = readLine()!!.toInt()
        if (expCurrent != actCurrent) {
            (expCurrent until actCurrent).forEach { println(it) }
            missingNumbersFlag = true
        }
        expCurrent = actCurrent + 1
    }
    if (!missingNumbersFlag) print("good job")
}
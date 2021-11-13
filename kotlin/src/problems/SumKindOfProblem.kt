package problems

fun main() {
    val cases = readLine()!!.toInt()
    for (case in 1..cases) {
        val (dataSetNumber, n) = readLine()!!.split(" ").map { it.toInt() }
        val sum = (n * (n + 1)) / 2
        val oddSum = n * n
        val evenSum = oddSum + n
        println("$dataSetNumber $sum $oddSum $evenSum")
    }
}
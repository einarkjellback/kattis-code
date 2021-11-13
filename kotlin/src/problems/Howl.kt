package problems

fun main() {
    val minHowlLength = readLine()!!.length
    val howl = "AWH".padEnd(minHowlLength + 1, 'O')
    println(howl)
}
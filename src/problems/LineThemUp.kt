package problems

fun main() {
    val n = readLine()!!.toInt()
    val lineup = arrayListOf<String>()
    for (i in 1..n) {
        lineup.add(readLine()!!)
    }
    val sortedLineup = arrayListOf<String>(*lineup.toTypedArray())
    sortedLineup.sort()
    when {
        sortedLineup == lineup -> print("INCREASING")
        sortedLineup.reversed() == lineup -> print("DECREASING")
        else -> print("NEITHER")
    }
}
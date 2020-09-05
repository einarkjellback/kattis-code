package problems

fun main() {
    val cases = readLine()!!.toInt()
    for (i in 1..cases) {
        val nm = readLine()!!.split(" ").map {it.toInt()}
        val n = nm[0]
        for (j in 1..nm[1]) readLine()
        println(n - 1)
    }
}
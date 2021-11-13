package problems

fun main() {
    val n = readLine()!!.toInt()
    var count = 0
    for (i in 1..n) {
        val battle = readLine()!!
        if (!battle.contains("CD")) count += 1
    }
    println(count)
}
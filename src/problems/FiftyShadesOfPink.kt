package problems

fun main() {
    val n = readLine()!!.toInt()
    var nShades = 0
    for (i in 1..n) {
        val str = readLine()!!
        if (str.contains("pink", ignoreCase = true) || str.contains("rose", ignoreCase = true)) {
            nShades += 1
        }
    }
    println(if (nShades == 0) "I must watch Star Wars with my daughter" else nShades)
}
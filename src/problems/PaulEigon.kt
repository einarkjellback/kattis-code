package problems

fun main() {
    val (n, p, q) = readLine()!!.split(" ").map { it.toInt() }
    println(if (((p + q) / n) % 2 == 0) "paul" else "opponent")
}
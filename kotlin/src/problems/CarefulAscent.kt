package problems

fun main() {
    // v = x * (y - sum[y_i * {1 + c_i}])^(-1)
    val (x, y) = readLine()!!.split(" ").map { it.toInt() }
    val n = readLine()!!.toInt()
    print(x / (y + (1..n).map {
        val (l, u, ci) = readLine()!!.split(" ")
        val yi = (u.toInt() - l.toInt())
        yi * (ci.toDouble() - 1)
    }.sum()))
}
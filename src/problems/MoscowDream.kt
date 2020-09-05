package problems

fun main() {
    val (a, b, c, n) = readLine()!!.split(" ").map { it.toInt() }
    if (a > 0 && b > 0 && c > 0 && n >= 3 && a + b + c >= n) print("YES")
    else print("NO")
}
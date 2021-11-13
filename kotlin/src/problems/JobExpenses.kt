package problems

fun main() {
    val n = readLine()!!.toInt()
    if (n > 0) {
        print(-readLine()!!
            .split(" ")
            .map { it.toInt() }
            .filter { it < 0 }
            .sum()
        )
    } else print (0)
}
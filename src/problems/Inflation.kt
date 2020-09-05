package problems

fun main() {
    val n = readLine()!!.toInt()
    val balloons = readLine()!!
        .split(" ")
        .map {it.toDouble()}
        .sorted()
        .zip(1..n) {b, i -> b / i}
    print(if (balloons.any {it > 1}) "impossible" else balloons.min())
}
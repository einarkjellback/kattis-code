package problems

fun main() {
    val (n, p, k) = readLine()!!.split(" ").map { it.toDouble() }
    var timestamps = readLine()!!.split(" ").map { it.toDouble() }
    timestamps = if (timestamps.last() != k) timestamps + k else timestamps
    var i = 1
    while (timestamps.size > 1) {
        val timeDilation = i * (p / 100.0) * (timestamps[1] - timestamps.first())
        timestamps = timestamps
            .drop(1)
            .map { it + timeDilation }
        i += 1
    }
    println(timestamps.last())
}
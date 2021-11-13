package problems

fun main() {
    val k = readLine()!!.toInt()
    var passes = 1
    var prev = 0
    for (i in 1..k) {
        val current = readLine()!!.toInt()
        if (prev > current) passes += 1
        prev = current
    }
    print(passes)
}
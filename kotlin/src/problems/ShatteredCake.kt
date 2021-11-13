package problems

fun main() {
    val w = readLine()!!.toInt()
    val pieces = readLine()!!.toInt()
    var acc = 0
    for (p in 1..pieces) {
        acc += readLine()!!
            .split(" ")
            .map { it.toInt() }
            .reduce {a, v -> a * v}
    }
    print(acc / w)
}
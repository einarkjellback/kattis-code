package problems

fun main() {
    val str = readLine()!!
    var acc = 0
    for (c in str) {
        acc += if (c == 'W') 1 else -1
    }
    print(if (acc == 0) 1 else 0)
}
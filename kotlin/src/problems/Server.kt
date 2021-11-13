package problems

fun main() {
    val (n, t) = readLine()!!.split(" ").map { it.toInt() }
    val tasks = readLine()!!.split(" ").map { it.toInt() }
    var i = 0
    var acc = 0
    while (i < n && acc + tasks[i] <= t) acc += tasks[i++]
    print(i)
}
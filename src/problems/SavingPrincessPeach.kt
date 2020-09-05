package problems

fun main() {
    val (n, found) = readLine()!!.split(" ").map { it.toInt() }
    val obstaclesObserved = IntArray(found) { readLine()!!.toInt() }.toSet()
    (0 until n)
        .filterNot { it in obstaclesObserved }
        .forEach { println(it) }
    val obstaclesFound = obstaclesObserved.size
    println("Mario got $obstaclesFound of the dangerous obstacles.")
}
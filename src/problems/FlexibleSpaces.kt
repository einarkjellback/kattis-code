package problems

fun main() {
    val (w, p) = readLine()!!.split(" ").map { it.toInt() }
    val partitions = listOf(0)
        .plus(readLine()!!.split(" ").map { it.toInt() })
        .plusElement(w)
    val dists = sortedSetOf<Int>()
    for (i in 1..p + 1) {
        val pi = partitions[i]
        for (j in 0 until i) {
            dists.add(pi - partitions[j])
        }
    }
    dists.forEach { print("$it ") }
}
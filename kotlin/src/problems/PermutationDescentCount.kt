package problems

fun main() {
    val cases = readLine()!!.toInt()
    for (case in 1..cases) {
        val (n, v) = readLine()!!.split(" ").drop(1).map { it.toInt() }
        println("$case " + pdc(n, v, listOf(1, 1)))
    }
}

fun pdc(n: Int, v: Int, col: List<Int>): Int {
    val currentN = col.size
    return if (currentN == n) {
        col[v]
    } else {
        val newCol = listOf(1) + col.zipWithNext().mapIndexed { i, (current, next) ->
            ((currentN - i) * current + (i + 2) * next) % 1001113
        } + listOf(1)
        // println(newCol)
        pdc(n, v, newCol)
    }
}

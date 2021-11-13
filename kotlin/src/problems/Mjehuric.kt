package problems

fun main() {
    val seq = readLine()!!.split(" ").map { it.toInt() }.toMutableList()
    while (!seq.isSorted() ) {
        for (i in 0 until seq.size - 1) {
            if (seq.isSorted()) break
            if (seq[i] > seq[i + 1]) {
                val temp = seq[i]
                seq[i] = seq[i + 1]
                seq[i + 1] = temp
                println(seq.joinToString(" "))
            }
        }
    }
}

private fun <E : Comparable<E>> List<E>.isSorted(): Boolean {
    this.zipWithNext().forEach { (current, next) ->
        if (current > next) return false
    }
    return true
}

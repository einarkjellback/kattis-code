package problems

fun main() {
    val pieceRepr = mapOf(
        1 to arrayOf(intArrayOf(0, 0, 0)),
        2 to arrayOf(intArrayOf(0)),
        3 to arrayOf(intArrayOf(0, -1), intArrayOf(1)),
        4 to arrayOf(intArrayOf(1, 0), intArrayOf(-1)),
        5 to arrayOf(intArrayOf(0, 0), intArrayOf(1), intArrayOf(-1), intArrayOf(1, -1)),
        6 to arrayOf(intArrayOf(0, 0), intArrayOf(0), intArrayOf(2), intArrayOf(-1, 0)),
        7 to arrayOf(intArrayOf(0, 0), intArrayOf(0), intArrayOf(-2), intArrayOf(0, 1))
    )

    val (cols, piece) = readLine()!!.split(" ").map {it.toInt()}
    val status = readLine()!!.split(" ").map {it.toInt()}
    val colDiff = status.zipWithNext { a, b -> a - b }.toIntArray()
    var acc = if (piece == 1) cols else 0
    for (p in pieceRepr.getValue(piece)) {
        for (i in 0..colDiff.size - p.size) {
            val aSlice = colDiff.sliceArray(i until i + p.size)
            if (p.contentEquals(aSlice)) acc += 1
        }
    }
    print(acc)
}
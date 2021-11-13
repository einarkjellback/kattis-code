package problems

fun main() {
    data class Pos(val x: Int, val y: Int)

    fun getAllKnightMoves(pos: Pos): Set<Pos> {
        return listOf(2, 2, -2, -2, 1, 1, -1, -1)
            .zip(listOf(1, -1, 1, -1, 2, -2, 2, -2))
            .map { (dx, dy) -> Pos(pos.x + dx, pos.y + dy) }
            .filter { (x, y) -> x in 0 until 5 && y in 0 until 5 }
            .toSet()
    }

    val knights = mutableSetOf<Pos>()
    for (y in 0 until 5) {
        readLine()!!.forEachIndexed { x, c -> if (c == 'k') knights.add(Pos(x, y)) }
    }

    var isValid = knights.size == 9
    if (isValid) {
        for (k in knights) {
            if (getAllKnightMoves(k).intersect(knights).isNotEmpty()) {
                isValid = false
                break
            }
        }
    }
    println(if (isValid) "valid" else "invalid")
}

package problems

import java.util.ArrayDeque

fun main() {
    data class Tile(val col: Int, val row: Int) {
        override fun toString(): String {
            return (col.toChar() + 'a'.toInt()).toString() + (row + 1).toString()
        }
    }

    val outOfBounds = { p: Tile -> !(p.col in 0..7 && p.row in 0..7)}

    fun getPossibleMoves(p: Tile): Set<Tile> {
        var newPositions = mutableSetOf<Tile>()
        for (dCol in listOf(-2, 2)) {
            for (dRow in listOf(-1, 1)) {
                newPositions.add(Tile(p.col + dCol, p.row + dRow))
            }
        }
        for (dRow in listOf(-2, 2)) {
            for (dCol in listOf(-1, 1)) {
                newPositions.add(Tile(p.col + dCol, p.row + dRow))
            }
        }
        return newPositions.filterNot(outOfBounds).toSet()
    }

    val cases = readLine()!!.toInt()
    val TOTAL_TILES = 64
    (1..cases).forEach { _ ->
        val position = readLine()!!
        val initTile = Tile(position[0] - 'a', position[1].toString().toInt() - 1)
        val visited = (1..8).map { (1..8).map { false }.toMutableList() }
        var visitedTilesInLastLayer = mutableListOf<Tile>()
        var currentLayerQueue = ArrayDeque<Tile>()
        currentLayerQueue.add(initTile)
        var nextLayerQueue = ArrayDeque<Tile>()
        var visitedTiles = 0
        var moves = 0
        while (visitedTiles < TOTAL_TILES) {
            if (nextLayerQueue.isEmpty()) {
                visitedTilesInLastLayer = mutableListOf()
            }
            val currentPos = currentLayerQueue.pop()
            if (!visited[currentPos.row][currentPos.col]) {
                visited[currentPos.row][currentPos.col] = true
                visitedTiles += 1
                visitedTilesInLastLayer.add(currentPos)
                nextLayerQueue.addAll(getPossibleMoves(currentPos))
            }
            if (currentLayerQueue.isEmpty()) {
                currentLayerQueue = nextLayerQueue
                nextLayerQueue = ArrayDeque()
                moves += 1
            }
        }
        visitedTilesInLastLayer.sortWith(compareBy({ -it.row }, { it.col }))
        println("$moves " + visitedTilesInLastLayer.joinToString(" "))
    }
}

package inf237_2020.graphs1

fun main() {
    /*
    No solution = end not reachable from start
    Unreachable cell = dfs from start until finished. If not all visited then unreachable cell exists
    Multiple paths = cycle detection
    Maze ok = none of the above applies

    I can do all of this in one dfs run
    */

    var input = readLine()!!
    while (input[0] != '0') {
        val (rows, cols) = input.split(" ").map { it.toInt() }
        val maze = Array(rows) {
            readLine()!!
                .toCharArray()
                .map { (if (it.isDigit()) it else (it - 'A') + 10).toString().toInt() }
                .toIntArray()
        }
        val (start, end) = findStartAndEnd(maze)
        val (hasSolution, visited, hasCycle)
                = dfs(start, maze, Array(rows) { BooleanArray(cols) })

        input = readLine()!!
    }
}

fun dfs(
    current: Entry,
    maze: Array<IntArray>,
    visited: Array<BooleanArray>
): Triple<Boolean, Array<BooleanArray>, Boolean> {
    val (row, col) = current
    val hasCycle = visited[row][col]
    visited[row][col] = true
    /*
    listOf(Entry(row - 1, col), Entry(row + 1, col), Entry(row, col - 1), Entry(row, col + 1)).forEach {
        if (!outOfBounds(it) )
        // val (hasSolution, visited, mayHaveCycle) = dfs()
    }
     */
    return Triple(true, arrayOf(), true)
}


fun outOfBounds(entry: Entry): Boolean {
    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
}

fun findStartAndEnd(maze: Array<IntArray>): Pair<Entry, Entry> {
    val dummyEntry = Entry(-1, -1)
    var start = dummyEntry
    var end = dummyEntry
    maze[0].forEachIndexed {col, cell ->
        if (cell in 0..7) {
            val newEntry = Entry(0,col)
            if (start == dummyEntry) end = newEntry
            else start = newEntry
        }
    }
    if (end != dummyEntry) {
        maze[maze.size - 1].forEachIndexed { col, cell ->
            if (cell in setOf(0,4,8,12,1,5,9,13)) {
                val newEntry = Entry(maze.size - 1,col)
                if (start == dummyEntry) end = newEntry
                else start = newEntry
            }
        }
        if (end != dummyEntry) {
            maze.forEachIndexed { row, cells ->
                val leftCell = cells.first()
                if (leftCell in setOf(0,4,8,12,2,6,10,14)) {
                    val newEntry = Entry(row, 0)
                    if (start == dummyEntry) end = newEntry
                    else start = newEntry
                }
                val rightCell = cells.last()
                if (rightCell in setOf(0,1,2,3,8,9,10)) {
                    val newEntry = Entry(row, maze.size - 1)
                    if (start == dummyEntry) end = newEntry
                    else start = newEntry
                }
            }
        }
    }
    return Pair(start, end)
}

data class Entry(val row: Int, val col: Int)
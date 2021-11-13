package problems

fun main() {
    val board = Array(7) { booleanArrayOf()}
    for (i in 0 until 7) {
        board[i] = readLine()!!
            .map { it != 'o'}
            .toBooleanArray()
    }
    var legalMoves = 0
    for (row in 0 until 7) {
        for (col in 0 until 7) {
            if (!outOfBounds(row, col) && board[row][col]) {
                legalMoves += countMoves(row, col, board)
            }
        }
    }
    print(legalMoves)
}

fun countMoves(row: Int, col: Int, board: Array<BooleanArray>): Int {
    var acc = 0
    for (dRow in arrayOf(-1, 1)) {
        val r = row + dRow
        if (outOfBounds(r + dRow, col).not() && board[r][col].not() && board[r + dRow][col].not()) {
            acc += 1
        }
    }
    for (dCol in arrayOf(-1, 1)) {
        val c = col + dCol
        if (outOfBounds(row, c + dCol).not() && board[row][c].not() && board[row][c + dCol].not()) {
            acc += 1
        }
    }
    return acc
}

fun outOfBounds(row: Int, col: Int): Boolean {
    return (if (row in 0..1 || row in 5..6) col in 2..4
    else row in 2..4 && col in 0..6).not()
}

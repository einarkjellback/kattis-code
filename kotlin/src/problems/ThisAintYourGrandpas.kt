package problems

fun main() {
    // "!!" means "If result from readLine is null throw a Nullpointer exception, else call toCharArray on the string"
    val n = readLine()!!.toInt()
    var board = Array(n) { CharArray(0) }
    for (i in 0 until n) {
        board[i] = readLine()!!.toCharArray()
    }


    var validBoard = isValid(board, n)
    if (validBoard == 1) {
        board = transpose(board, n)
        validBoard = isValid(board, n)
    }
    print(validBoard)
}

fun transpose(board: Array<CharArray>, n: Int): Array<CharArray> {
    val trans = Array(n) {CharArray(n)}
    for (row in 0 until n) {
        for (col in 0 until n) {
            trans[col][row] = board[row][col]
        }
    }
    return trans
}

private fun isValid(board: Array<CharArray>, n: Int): Int {
    for (row in board) {
        if (row.count { it == 'W' } != n / 2) return 0
        var cnt = 0
        var prevChar = 'W'
        for (c in row) {
            if (prevChar != c) {
                prevChar = c
                cnt = 1
            } else cnt += 1
            if (cnt == 3) return 0
        }
    }
    return 1
}
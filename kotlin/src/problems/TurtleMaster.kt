package problems

fun main() {
    val board = Array(8) { charArrayOf() }
    for (i in 0 until 8) {
        board[i] = readLine()!!.toCharArray()
    }
    val instructions = readLine()!!
    var pos = Pair(0, 7)
    board[pos.second][pos.first] = '.'
    var dir = 'e'
    var instructionIndex = 0
    for (c in instructions) {
        instructionIndex += 1
        if (c == 'X') {
            val nextPos = getNextPos(pos, dir)
            if (outOfBounds(pos) || board[nextPos.second][nextPos.first] != 'I') {
                break
            } else board[nextPos.second][nextPos.first] = '.'
        }
        else if (c == 'F') {
            pos = getNextPos(pos, dir)
            if (outOfBounds(pos) || (board[pos.second][pos.first] != '.' && board[pos.second][pos.first] != 'D')) {
                break
            }
        } else dir = turn(c, dir)
    }
    if (!outOfBounds(pos) && instructionIndex == instructions.length && board[pos.second][pos.first] == 'D') {
        print("Diamond!")
    } else print("Bug!")
}

fun turn(rOrL: Char, dir: Char): Char {
    if (rOrL == 'R') {
        return when (dir) {
            'e' -> 's'
            's' -> 'w'
            'w' -> 'n'
            else -> 'e'
        }
    }
    return when (dir) {
        'e' -> 'n'
        's' -> 'e'
        'w' -> 's'
        else -> 'w'
    }
}

fun getNextPos(pos: Pair<Int, Int>, dir: Char): Pair<Int, Int> {
    return when (dir) {
        'e' -> Pair(pos.first + 1, pos.second)
        's' -> Pair(pos.first, pos.second + 1)
        'w' -> Pair(pos.first - 1, pos.second)
        else -> Pair(pos.first, pos.second - 1)
    }
}

fun outOfBounds(pos: Pair<Int, Int>): Boolean {
    val (x, y) = pos
    return x < 0 || x >= 8 || y < 0 || y >= 8
}
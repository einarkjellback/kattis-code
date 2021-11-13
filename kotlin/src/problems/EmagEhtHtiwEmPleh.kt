package problems

fun main() {
    var board =
        "+---+---+---+---+---+---+---+---+\n" +
        "|...|:::|...|:::|...|:::|...|:::|\n" +
        "+---+---+---+---+---+---+---+---+\n" +
        "|:::|...|:::|...|:::|...|:::|...|\n" +
        "+---+---+---+---+---+---+---+---+\n" +
        "|...|:::|...|:::|...|:::|...|:::|\n" +
        "+---+---+---+---+---+---+---+---+\n" +
        "|:::|...|:::|...|:::|...|:::|...|\n" +
        "+---+---+---+---+---+---+---+---+\n" +
        "|...|:::|...|:::|...|:::|...|:::|\n" +
        "+---+---+---+---+---+---+---+---+\n" +
        "|:::|...|:::|...|:::|...|:::|...|\n" +
        "+---+---+---+---+---+---+---+---+\n" +
        "|...|:::|...|:::|...|:::|...|:::|\n" +
        "+---+---+---+---+---+---+---+---+\n" +
        "|:::|...|:::|...|:::|...|:::|...|\n" +
        "+---+---+---+---+---+---+---+---+"

    data class Pos(val piece: Char, val col: Int, val row: Int)
    val whitePieces = readLine()!!
        .drop(7)
    var pieces = listOf<Pos>()
    if (whitePieces.isNotEmpty()) {
        pieces = pieces + whitePieces
            .split(',')
            .map { if (it.length == 2) "p$it" else it.first().toLowerCase() + it.drop(1) }
            .map { Pos(it[0], it[1] - 'a', it[2].toString().toInt() - 1) }
    }
    val blackPieces = readLine()!!
        .drop(7)
    if (blackPieces.isNotEmpty()) {
        pieces = pieces + (
                blackPieces
                    .split(',')
                    .map { if (it.length == 2) "P$it" else it }
                    .map { Pos(it[0], it[1] - 'a', it[2].toString().toInt() - 1) }
                )
    }

    val convertToLinearIndex = { col: Int, row: Int -> 34 * (15 - row * 2) + 3 + col * 4 }
    for ((piece, col, row) in pieces) {
        val i = convertToLinearIndex(col, row)
        board = board.take(i - 1) + piece + board.drop(i)
    }
    print(board)
}

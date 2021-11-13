package problems

fun main() {

    val cases = readLine()!!.toInt()
    for (case in 1..cases) {
        val word = readLine()!!
        var sequence = ""
        word.zipWithNext().forEach {(current, next) ->
            val digit = charToInt(current)
            sequence = sequence.plus(digit.toString().repeat(subgroupRank(current)))
            if (digit == charToInt(next)) sequence = sequence.plus(' ')
        }
        val c = word.last()
        sequence = sequence.plus(
            charToInt(c).toString().repeat(subgroupRank(c))
        )
        println("Case #$case: $sequence" )
    }
}

fun charToInt(c: Char): Int {
    val i = c.toInt() - 'a'.toInt()
    return when (c) {
        in 'a'..'o' -> i / 3 + 2
        in 'p'..'s' -> 7
        in 't'..'v' -> 8
        in 'w'..'z' -> 9
        else -> 0
    }
}

fun subgroupRank(c: Char): Int {
    val i = c.toInt()
    return when (c) {
        ' ' -> 1
        in 'a'..'o' -> (i - 'a'.toInt()) % 3 + 1
        in 'p'..'s' -> (i - 'p'.toInt()) % 4 + 1
        in 't'..'v' -> (i - 't'.toInt()) % 3 + 1
        else -> (i - 'w'.toInt()) % 4 + 1
    }
}
package problems

fun main() {
    val word = readLine()!!
    val alphaPerm = readLine()!!.asIterable()
    if (willWin(word, alphaPerm, 10)) print("WIN")
    else print("LOSE")
}

fun willWin(word: String, alphaPerm: Iterable<Char>, guessesLeft: Int): Boolean {
    if (guessesLeft == 0) return false
    if (word.isEmpty()) return true
    val c = alphaPerm.first()
    return willWin(
        word.filter { it != c },
        alphaPerm.drop(1),
        if (word.contains(c)) guessesLeft else guessesLeft - 1
    )
}

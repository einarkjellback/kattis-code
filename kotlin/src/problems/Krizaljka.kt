package problems

fun main() {
    val (wordA, wordB) = readLine()!!.split(" ")
    var row = 0
    var col = 0
    outer@ for (charA in wordA) {
        for (charB in wordB) {
            if (charA == charB) break@outer
            row += 1
        }
        row = 0
        col += 1
    }
    for (i in 0 until wordB.length) {
        if (i == row) {
            println(wordA)
        } else println("."
            .repeat(col)
            .plus(wordB[i])
            .plus(".".repeat(wordA.length - col - 1)))
        println()
    }
}
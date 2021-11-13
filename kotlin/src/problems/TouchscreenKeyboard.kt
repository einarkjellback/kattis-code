package problems

import kotlin.math.abs

fun main() {
    val keyboard =
        ("qwertyuiop," +
        "asdfghjkl," +
        "zxcvbnm")
            .split(",")
            .map { it.toCharArray().toList() }
    val table = mutableMapOf<Char, Pair<Int, Int>>()
    for ((rowi, row) in keyboard.indices.zip(keyboard)) {
        for ((coli, c) in row.indices.zip(row)) {
            table[c] = Pair(rowi, coli)
        }
    }

    val cases = readLine()!!.toInt()
    for (case in 1..cases) {
        val (typedWord, numberOfSuggestions) = readLine()!!.split(" ")
        val suggestions = (1..numberOfSuggestions.toInt()).map { readLine()!! }.sorted()
        val suggestionsAndDist = suggestions.map { suggestion ->
            val dist = typedWord.zip(suggestion).map {
                val (rowTyped, colTyped) = table.getValue(it.first)
                val (rowSugg, colSugg) = table.getValue(it.second)
                abs(rowTyped - rowSugg) + abs(colTyped - colSugg)
            }.sum()
            Pair(suggestion, dist)
        }.sortedBy { it.second }
        println(suggestionsAndDist.joinToString("\r\n") { it.first + " " + it.second })
    }
}
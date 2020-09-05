package problems

import kotlin.math.pow

fun main() {
    var paragraph = mutableListOf<String>()
    var sentence = readLine()
    while (sentence != null) {
        paragraph.add(sentence)
        sentence = readLine()
    }
    val longestSentence = paragraph.maxBy { it.length }!!.length
    print(paragraph
        .dropLast(1)
        .map { (longestSentence - it.length).toDouble().pow(2) }
        .sum()
        .toInt()
    )
}
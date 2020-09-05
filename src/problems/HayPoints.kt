package problems

fun main() {
    val (nWords, nDescriptions) = readLine()!!.split(" ").map { it.toInt() }
    val wordsToPoints = (1..nWords).associate {
        val wordAndPoints = readLine()!!.split(" ")
        Pair(wordAndPoints[0], wordAndPoints[1].toInt())
    }
    val jobDescriptions = (1..nDescriptions).map {
        var description = readLine()!! + " "
        while (description[description.length - 2] != '.') {
            description += readLine()!! + " "
        }
        description
    }

    for (description in jobDescriptions) {
        var accPoints = 0
        for (word in description.split(" ")) {
            accPoints += wordsToPoints.getOrDefault(word, 0)
        }
        println(accPoints)
    }
}
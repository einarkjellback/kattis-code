package problems

fun main() {
    val alternateA = mapOf(
        "A#" to "Bb",
        "C#" to "Db",
        "D#" to "Eb",
        "F#" to "Gb",
        "G#" to "Ab"
    )
    val alternateB = alternateA.entries.associateBy( { it.value }) { it.key }

    var key = readLine()
    var case = 1
    while (key != null) {
        val (letter, mode) = key.split(" ")
        var alternateKey = alternateA.getOrDefault(letter, letter)
        if (alternateKey == letter) alternateKey = alternateB.getOrDefault(letter, letter)
        if (alternateKey == letter) println("Case $case: UNIQUE")
        else println("Case $case: $alternateKey $mode")
        case += 1
        key = readLine()
    }
}
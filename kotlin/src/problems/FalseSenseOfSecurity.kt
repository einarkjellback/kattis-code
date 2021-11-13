package problems

fun main() {
    val charToMorse = mapOf(
        'A' to ".-", 'B' to "-...", 'C' to "-.-.", 'D' to "-..", 'E' to ".", 'F' to "..-.", 'G' to "--.", 'H' to "....",
        'I' to "..", 'J' to ".---", 'K' to "-.-", 'L' to ".-..", 'M' to "--", 'N' to "-.", 'O' to "---", 'P' to ".--.",
        'Q' to "--.-", 'R' to ".-.", 'S' to "...", 'T' to "-", 'U' to "..-", 'V' to "...-", 'W' to ".--", 'X' to "-..-",
        'Y' to "-.--", 'Z' to "--..", '_' to "..--", ',' to ".-.-", '.' to "---.", '?' to "----"
    )
    val morseToChar = mutableMapOf<String, Char>()
    charToMorse.entries.forEach {morseToChar[it.value] = it.key}

    var encrypted = readLine() ?: ""
    while (encrypted.isNotEmpty()) {
        val numbers = Array(encrypted.length) {0}
        encrypted.forEachIndexed {i, c -> numbers[encrypted.length - 1 - i] = charToMorse.getValue(c).length}
        val morse = encrypted.map {charToMorse.getValue(it)}.toMutableList()
        var morseJoined = morse.joinToString("")
        numbers.forEachIndexed {i, n ->
            morse[i] = morseJoined.take(n)
            morseJoined = morseJoined.drop(n)
        }
        val decrypted = morse.map {morseToChar.getValue(it)}
        println(decrypted.joinToString(""))
        encrypted = readLine() ?: ""
    }
}

package problems

fun main() {
    val dictionarySize = readLine()!!.toInt()
    val dictionary = List (dictionarySize) { readLine()!! }.toMutableSet()
    val keysPressed = readLine()!!.asSequence().map { it.toString().toInt() - 2}
    val keyMap = listOf("abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz")
    keysPressed.forEachIndexed { index, i ->
        val wordsToRemove = mutableSetOf<String>()
        for (word in dictionary) {
            if (word.length <= index || !keyMap[i].contains(word[index])) {
                wordsToRemove.add(word)
            }
        }
        dictionary.removeAll(wordsToRemove)
    }
    println(dictionary.size)
}
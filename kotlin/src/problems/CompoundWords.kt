package problems

fun main() {
    val words = mutableListOf<String>()
    val compounds = sortedSetOf<String>()
    var w = readLine() ?: ""
    while (w != "") {
        words.addAll(w.split(" "))
        w = readLine() ?: ""
    }
    for (i in 0 until words.size) {
        for (j in i + 1 until words.size) {
            compounds.add(words[i].plus(words[j]))
            compounds.add(words[j].plus(words[i]))
        }
    }
    compounds.forEach {println(it)}
}
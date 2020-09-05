package problems

fun main() {
    val cards = mutableListOf<String>()
    while (cards.size < 12) {
        cards.addAll(readLine()!!.split(" "))
    }
    var foundSet = false
    for (i in 1..12 - 2) {
        val cardA = cards[i - 1]
        for (j in i + 1..12 - 1) {
            val cardB = cards[j - 1]
            for (k in j + 1..12) {
                val cardC = cards[k - 1]
                val features = Array(4) {mutableSetOf<Char>()}
                for (f in 0 until 4) {
                    features[f].addAll(arrayOf(cardA[f], cardB[f], cardC[f]))
                }
                if (features.all { it.size != 2 }) {
                    println("$i $j $k")
                    foundSet = true
                }
            }
        }
    }
    if (!foundSet) print("no sets")
}
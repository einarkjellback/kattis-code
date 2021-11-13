package problems

fun main() {
    val dwarfes = IntArray(9) { readLine()!!.toInt() }
    val sumDiff = dwarfes.sum() - 100
    var trueDwarfes = listOf<Int>()
    for (i in 0 until 8) {
        for (j in i + 1 until 9) {
            if (dwarfes[i] + dwarfes[j] == sumDiff) {
                trueDwarfes = dwarfes.take(i).plus(dwarfes.slice(i + 1 until j).plus(dwarfes.drop(j + 1)))
            }
        }
    }
    trueDwarfes.forEach { println(it) }
}
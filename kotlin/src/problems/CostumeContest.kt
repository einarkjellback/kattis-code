package problems

fun main() {
    val categoryCount = sortedMapOf<String, Int>().withDefault { 0 }
    val n = readLine()!!.toInt()
    for (i in 1..n) {
        val category = readLine()!!
        categoryCount[category] = categoryCount.getValue(category) + 1
    }
    val minFreq = categoryCount.values.min()
    categoryCount
        .filterValues { it == minFreq }
        .forEach { println(it.component1()) }
}
package problems

fun main() {
    val x = readLine()!!
    val xAsList = x.toCharArray().toList()
    val permsOfX = allPermutations(xAsList)
        .map { it.joinToString("").toInt() }
        .filter { it > x.toInt() }
    println(if (permsOfX.isEmpty()) 0 else permsOfX.min())
}

fun <T> allPermutations(permute: List<T>): List<List<T>> {
    if (permute.size == 1) return listOf(permute)
    val permutations = mutableListOf<List<T>>()
    val el = permute.first()
    for (perm in allPermutations(permute.drop(1))) {
        for (i in 0..perm.size) {
            val newPerm = perm.toMutableList()
            newPerm.add(i, el)
            permutations.add(newPerm)
        }
    }
    return permutations
}

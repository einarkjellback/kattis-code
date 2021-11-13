package problems

fun main() {
    val cases = readLine()!!.toInt()
    for (case in 1..cases) {
        val (_, n) = readLine()!!.split(" ").map { it.toInt() }
        val path = buildPath(n)
        val (nom, denom) = findNomDenom(path, 1, 1)
        println("$case $nom/$denom")
    }
}

fun findNomDenom(path: Sequence<Boolean>, n: Int, d: Int): Pair<Int, Int> {
    if (path.any().not()) return Pair(n, d)
    val goRight = path.first()
    return if (goRight) findNomDenom(path.drop(1), n + d, d)
    else findNomDenom(path.drop(1), n, n + d)
}

fun buildPath(i: Int): Sequence<Boolean> {
    if (i == 1) return sequenceOf()
    if (i % 2 == 0) return buildPath(i / 2).plusElement(false)
    return buildPath(((i - 1) / 2)).plusElement(true)
}
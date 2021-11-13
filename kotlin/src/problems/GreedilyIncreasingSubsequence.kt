package problems

fun main() {
    //readLine()!!.toInt()
    //val permutation = readLine()!!.split(" ").map { it.toInt() }
    val permutation = 1..1000000
    val l = permutation.fold(Pair(0, emptyList<Int>())) {
            (prevValue, increasingSeqs), nextValue ->
        if (nextValue > prevValue) Pair(nextValue, increasingSeqs + nextValue)
        else Pair(nextValue, increasingSeqs)
    }.second
    println(l.size)
    println(l.joinToString(" "))
}
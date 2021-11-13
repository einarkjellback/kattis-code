package problems

fun main() {
    var input = readLine()!!
    while (input[0] != '0') {
        val (katA, katB, hyp) = input.split(" ").map { it.toInt() }.sorted()
        println(if (katA * katA + katB * katB == hyp * hyp) "right" else "wrong")
        input = readLine()!!
    }
}
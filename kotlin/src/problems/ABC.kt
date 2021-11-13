package problems

fun main() {
    val abc = readLine()!!
        .split(" ")
        .map { it.toInt() }
        .sorted()
    val order = readLine()!!
        .toCharArray()
        .map { it - 'A' }

    for (i in order) {
        print(abc[i])
        print(" ")
    }
}
package problems

fun main() {
    val numbers = readLine()!!
        .split(" ")
        .map { it.toInt() }
        .sorted()
    val n = numbers
        .zipWithNext() { i, j -> j - i }
        .min()!!
    if (n == 0) print(numbers[0])
    else print(generateSequence(numbers.min()) { it + n }
        .filterNot { it in numbers }
        .first())
}
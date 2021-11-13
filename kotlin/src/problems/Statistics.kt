package problems

fun main() {
    var input = readLine()
    var case = 1
    while (input != null) {
        val data = input.split(" ").map { it.toInt() }.drop(1)
        val min = data.min()!!
        val max = data.max()!!
        val range = max - min
        println("Case $case: $min $max $range")
        case += 1
        input = readLine()
    }
}
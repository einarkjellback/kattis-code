package problems

fun main() {
    var input = readLine()
    while (input != null) {
        val integers = input.split(" ").map { it.toInt() }
        for (i in 0..integers.size) {
            if (integers[i] == integers.take(i).sum() + integers.drop(i + 1).sum()) {
                println(integers[i])
                break
            }
        }
        input = readLine()
    }
}
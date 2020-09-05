package problems

fun main() {
    var input = readLine()
    var case = 1
    while (input != null) {
        var (e, m) = input.split(" ").map { it.toInt() }
        val originalM = m
        if (e == 0 && m == 0) {
            println("Case $case: 0")
        } else {
            m += 365 - e
            while (m % 687 != 0) {
                m += 365
            }
            println("Case $case: " + (m - originalM))
        }
        input = readLine()
        case += 1
    }
}
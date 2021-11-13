package problems

fun main() {
    var n = readLine()!!
    n = if (n.length % 3 != 0) "0".repeat(3 - n.length % 3).plus(n) else n
    n
        .indices
        .filter { it % 3 == 0 }
        .forEach {
            print(Integer.parseInt(n.slice(it until it + 3), 2))
        }
}
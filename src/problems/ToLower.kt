package problems

fun main() {
    val (p, t) = readLine()!!.split(" ").map {it.toInt()}
    var acc = 0
    for (problem in 1..p) {
        var convertible = true
        for (case in 1..t) {
            if (readLine()!!.drop(1).any {it in 'A'..'Z'}) {
                convertible = false
            }
        }
        if (convertible) acc += 1
    }
    print(acc)
}
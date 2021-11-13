package problems

fun main() {
    val cases = readLine()!!.toInt()
    for (case in 1..cases) {
        val n = readLine()!!.split(" ")[1].toInt()
        println("" + case + " " + n * (n + 3) / 2)
    }
}
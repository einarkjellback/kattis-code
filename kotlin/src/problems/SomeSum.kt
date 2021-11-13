package problems
fun main() {
    val n = readLine()!!.toInt()
    if (n % 2 == 0) {
        if (n % 4 == 0) print("Even")
        else print("Odd")
    } else print("Either")
}
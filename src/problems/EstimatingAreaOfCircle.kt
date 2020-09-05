package problems

import kotlin.math.PI

fun main() {
    var input = readLine()!!
    while (input != "0 0 0") {
        val rmc = input.split(" ")
        val r = rmc[0].toDouble(); val m = rmc[1].toInt(); val c = rmc[2].toInt()
        print(PI * r * r)
        print(" ")
        println(c * 4 * r * r / m)
        input = readLine()!!
    }
}
package problems

import kotlin.math.*

fun main() {
    var input = readLine()
    while (input != null) {
        val (r, x, y) = input.split(" ").map { it.toDouble() }
        val hSquare = x * x + y * y
        val rSquare = r * r
        if (rSquare <= hSquare) println("miss")
        else {
            val h = sqrt(hSquare)
            val areaThis = rSquare * acos(h / r) - h * sqrt(rSquare - hSquare)
            val areaOther = PI * rSquare - areaThis
            print(max(areaThis, areaOther))
            print(" ")
            println(min(areaThis, areaOther))
        }
        input = readLine()
    }
}
package problems

import java.util.regex.Pattern

fun main() {
    var line = readLine()
    while (line != null) {
        println(if (line.contains(Regex(".*(?i)problem.*"))) "yes" else "no")
        line = readLine()
    }
}
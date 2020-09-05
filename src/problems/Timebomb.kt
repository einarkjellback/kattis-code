package problems


fun main() {
    val stringToDigit = mapOf(
        "**** ** ** ****" to 0,
        "  *  *  *  *  *" to 1,
        "***  *****  ***" to 2,
        "***  ****  ****" to 3,
        "* ** ****  *  *" to 4,
        "****  ***  ****" to 5,
        "****  **** ****" to 6,
        "***  *  *  *  *" to 7,
        "**** ***** ****" to 8,
        "**** ****  ****" to 9
    )
    var row = readLine()!!
    val digitsStr = Array((row.length + 1) / 4) {""}
    for (i in 1..5) {
        var j = 0
        while (row.isNotEmpty()) {
            digitsStr[j] = digitsStr[j].plus(row.take(3))
            row = row.drop(4)
            j += 1
        }
        if (i != 5) row = readLine()!!
    }
    var digits = digitsStr.map {stringToDigit.getOrDefault(it, -1)}
    if (digits.any { it == -1 }) {
        print("BOOM!!")
    } else {
        digits = digits.dropWhile { it == 0 }
        val number = digits.joinToString("").toInt()
        if (number % 6 == 0) print("BEER!!")
        else print("BOOM!!")
    }
}
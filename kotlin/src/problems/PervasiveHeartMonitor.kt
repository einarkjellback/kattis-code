package problems

fun main() {
    var input = readLine()!!
    while(input != "") {
        val info = input.split(" ")
        val name = (
                if (info[0][0].isLetter()) info.takeWhile { it[0].isLetter()}
                else info.dropWhile { it[0].isDigit() })
            .joinToString(" ")
        val heartRates = (
            if (info[0][0].isLetter()) info.dropWhile { it[0].isLetter()}
            else info.takeWhile { it[0].isDigit() })
            .map { it.toDouble() }
        print(heartRates.average())
        println(" $name")
        input = readLine()!!
    }
}
package problems

fun main() {
    val cases = readLine()!!.toInt()
    (1..cases).forEach { _ ->
        val (days, months) = readLine()!!.split(" ").map { it.toInt() }
        val daysInMonths = readLine()!!.split(" ").map { it.toInt() }

        var monthStartsAtDay = 6
        var friday13ths = 0
        for (daysInMonth in daysInMonths) {
            if (daysInMonth >= 13 && monthStartsAtDay == 6) {
                friday13ths += 1
            }
            monthStartsAtDay = (monthStartsAtDay + daysInMonth) % 7
        }
        println(friday13ths)
    }
}
package problems

fun main() {
    val cases = readLine()!!.toInt()
    for (i in 1..cases) {
        val input = readLine()!!.split(" ")
        var isEligible = false
        when {
            input[1].take(4).toInt() >= 2010 -> isEligible = true
            input[2].take(4).toInt() >= 1991 -> isEligible = true
        }
        print(input[0] + " ")
        if (isEligible) println("eligible")
        else if (!isEligible && input[3].toInt() >= 41) println("ineligible")
        else println("coach petitions")
    }
}
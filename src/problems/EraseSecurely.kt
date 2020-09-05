package problems

fun main() {
    val n = readLine()!!.toInt()
    val original = readLine()!!
    val deleted = readLine()!!
    var isDeleted = true
    val checkIfDeleted = if (n % 2 == 0) { o: Char, d: Char -> o ==  d} else { o: Char, d: Char -> o != d}
    original.zip(deleted).forEach { (o, d) ->
        if (!checkIfDeleted(o, d)) {
            isDeleted = false
            return@forEach
        }
    }
    print(if (isDeleted) "Deletion succeeded" else "Deletion failed")
}
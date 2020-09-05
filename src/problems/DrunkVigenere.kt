package problems

fun main() {
    val encryptedMsg = readLine()!!.toCharArray().map { it - 'A' }
    val shifts = readLine()!!.toCharArray().map { it - 'A' }.mapIndexed { i, c -> if (i % 2 == 1) 26 - c else c }
    println((
            encryptedMsg.zip(shifts) { c, shift -> (c + 26 - shift) % 26 }
            ).map { (it + 'A'.toInt()).toChar() }
        .joinToString("")
    )
}
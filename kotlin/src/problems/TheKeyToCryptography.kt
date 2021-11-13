package problems

fun main() {
    val encryptedMsg = readLine()!!
    var key = readLine()!!
    val shift = key.length
    encryptedMsg.forEachIndexed { i, c ->
        val decryptedChar = ((c.toInt() + 26 - key[i].toInt()) % 26 + 'A'.toInt()).toChar()
        key = key.plus(decryptedChar)
    }
    print(key.drop(shift))
}

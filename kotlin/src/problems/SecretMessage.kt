package problems

import kotlin.math.ceil
import kotlin.math.sqrt


// Incorporate redundant layers and avoid iterating through these
fun main() {
    val cases = readLine()!!.toInt()
    for (case in 1..cases) {
        var encryptedMsg = readLine()!!
        val msgLength = encryptedMsg.length
        val paddedLength = ceil(sqrt(msgLength.toDouble())).toInt()
        val m = paddedLength * paddedLength
        encryptedMsg = encryptedMsg.plus("*".repeat(m - msgLength))
        var decryptedMsg = ""
        for (i in m - paddedLength until m) {
            for (j in i downTo 0 step paddedLength) {
                if (encryptedMsg[j] != '*') decryptedMsg = decryptedMsg.plus(encryptedMsg[j])
            }
        }
        println(decryptedMsg)
    }
}
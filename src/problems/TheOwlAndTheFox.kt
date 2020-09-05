package problems

fun main() {
    val cases = readLine()!!.toInt()
    for (case in 1..cases) {
        var nStr = readLine()!!
        for (i in nStr.indices.reversed()) {
            if (nStr[i] != '0') {
                val c = nStr[i].toString().toInt() - 1
                nStr = nStr.take(i).plus(c).plus(nStr.drop(i + 1))
                break
            }
        }
        if (nStr.all { it == '0' }) println(0)
        else println(nStr)
    }
}
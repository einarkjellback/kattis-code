package problems

fun main() {
    val lengthMarius = readLine()!!.length
    val lengthDoctor = readLine()!!.length
    print(if (lengthDoctor > lengthMarius) "no" else "go")
}
package problems

fun main() {
    val bites = readLine()!!.toInt()
    val counting = readLine()!!.split(" ")
    var isCorrect = true
    for (bite in 1..bites) {
        val phrase = counting[bite - 1]
        if (phrase != "mumble" && phrase.toInt() != bite) {
            isCorrect = false
            break
        }
    }
    print(if (isCorrect) "makes sense" else "something is fishy")
}
package problems

fun main() {
    val sentence = readLine()!!.split(" ")
    var aeCount = 0.0
    for (word in sentence) {
        if (word.contains(other = "ae")) aeCount += 1
    }
    print(if (aeCount / sentence.size >= 0.4) "dae ae ju traeligt va" else "haer talar vi rikssvenska")
}
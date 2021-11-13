package problems

fun main() {
    val msg = readLine()!!
    val delimiter = msg.length / 3
    val words = listOf(msg.take(delimiter), msg.drop(delimiter).take(delimiter), msg.drop(delimiter * 2))
    val wordsAsCharArrays = words.map { it.toCharArray()}
    val (fstWord, sndWord, trdWord) = wordsAsCharArrays
    when {
        fstWord.zip(sndWord) { fst, snd -> fst - snd }.sum() == 0 -> {
            println(fstWord)
        }
        fstWord.zip(trdWord) { fst, snd -> fst - snd }.sum() == 0 -> {
            println(fstWord)
        }
        else -> {
            println(sndWord)
        }
    }
}
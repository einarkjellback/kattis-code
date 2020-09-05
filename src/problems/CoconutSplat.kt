package problems

fun main() {
    val (s, n) = readLine()!!.split(" ").map { it.toInt() }
    val playersLeft = (1..n).toMutableSet()
    val hands = IntArray(2 * n) { 0 }
    var i = 0
    var cnt = 1
    while (playersLeft.size > 1) {
        when {
            hands[i] == 3 -> i = (i + 1) % hands.size
            cnt < s -> {
                when (hands[i]) {
                    0 -> {
                        i = (i + 2) % hands.size
                        cnt += 1
                    }
                    3 -> i = (i + 1) % hands.size
                    else -> {
                        i = (i + 1) % hands.size
                        cnt += 1
                    }
                }
            }
            else -> {
                when (hands[i]) {
                    0 -> {
                        hands[i] = 1
                        hands[i + 1] = 1
                    }
                    1 -> {
                        hands[i] = 2
                        i = (i + 1) % hands.size
                    }
                    2 -> {
                        hands[i] = 3
                        if (i % 2 == 0 && hands[i + 1] == 3) playersLeft.remove(i / 2 + 1)
                        else if (i % 2 == 1 && hands[i - 1] == 3) playersLeft.remove(i / 2 + 1)
                        i = (i + 1) % hands.size
                    }
                }
                cnt = 1
            }
        }
    }
    print(playersLeft.first())
}
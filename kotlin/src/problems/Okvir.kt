package problems

fun main() {
    val (m, n) = readLine()!!.split(" ").map { it.toInt() }
    val (u, l, r, d) = readLine()!!.split(" ").map { it.toInt() }
    val words = (1..m).map { readLine()!! }

    var upperPadding = (1..u).joinToString("\n") { i ->
        (1..l + r + n).joinToString("") { j -> if ((j + i) % 2 == 0) "#" else "." }
    }
    upperPadding += if (upperPadding.isEmpty()) "" else "\n"

    val bottomPadding = (u + m + 1..u + m + d).joinToString("\n") { i ->
        (1..l + n + r).joinToString("") { j -> if ((j + i) % 2 == 0) "#" else "." }
    }

    val rightPaddedWords = words.mapIndexed { i, s ->
        s + (l + n + 1..l + n + r).joinToString("") { j -> if ((u + i + j) % 2 == 0) "." else "#" }
    }

    val sidePaddedWords = rightPaddedWords.mapIndexed { i, s ->
        (1..l).joinToString("") { j -> if ((u + i + j) % 2 == 0) "." else "#" } + s
    }.joinToString("\n") + "\n"

    println(upperPadding + sidePaddedWords + bottomPadding)
}
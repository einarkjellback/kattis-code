package problems

fun main() {
    var input = readLine()
    while (input != null) {
        var (mosqs, pupae, larvae, eggsLain, larvaSurvival, pupaeSurvival, weeks)
                = input.split(" ").map { it.toInt() }
        for (week in 1..weeks) {
            val temp = mosqs
            mosqs = pupae / pupaeSurvival
            pupae = larvae / larvaSurvival
            larvae = temp * eggsLain
        }
        println(mosqs)
        input = readLine()
    }
}

private operator fun <E> List<E>.component7(): E {
    return this[6]
}

private operator fun <E> List<E>.component6(): E {
    return this[5]
}

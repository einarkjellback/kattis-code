package problems

fun main() {
    val (s, t, _) = readLine()!!.split(" ").map { it.toInt() }
    val walkTimes = readLine()!!.split(" ").map { it.toInt() }
    val driveTimes = readLine()!!.split(" ").map { it.toInt() }
    val arrivalIntervals = readLine()!!.split(" ").map { it.toInt() }

    var accTime = s
    for ((d, b, c) in (walkTimes zip driveTimes).zip(arrivalIntervals)
                                        { fst, snd -> Triple(fst.first, fst.second, snd) }) {
        accTime += d + b
        accTime += accTime % c
    }
    accTime += walkTimes.last()
    println(if (accTime <= t) "yes" else "no")
}
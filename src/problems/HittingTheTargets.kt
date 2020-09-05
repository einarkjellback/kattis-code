package problems

fun main() {
    val nTargets = readLine()!!.toInt()
    val targets = List(nTargets) { readLine()!!.split(" ").drop(1).map { it.toInt() } }
    val nShots = readLine()!!.toInt()
    for (i in 1..nShots) {
        val (x, y) = readLine()!!.split(" ").map { it.toInt() }
        var targetsHit = 0
        for (target in targets) {
            if (target.size == 3) {
                val xNorm = x - target[0]
                val yNorm = y - target[1]
                val r = target[2]
                if (xNorm * xNorm + yNorm * yNorm <= r * r) targetsHit += 1
            } else {
                val (xA, yA, xB, yB) = target
                if (x in xA..xB && y in yA..yB) targetsHit += 1
            }
        }
        println(targetsHit)
    }
}
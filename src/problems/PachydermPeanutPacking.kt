package problems

fun main() {
    var nBoxes = readLine()!!.toInt()
    while (nBoxes != 0) {
        val boxes = List(nBoxes) {
            val (x1, y1, x2, y2, size) = readLine()!!.split(" ")
            Box(x1.toDouble(), y1.toDouble(), x2.toDouble(), y2.toDouble(), size)
        }
        val peanuts = readLine()!!.toInt()
        for (i in 0 until peanuts) {
            val (x, y, size) = readLine()!!.split(" ")
            val peanut = Peanut(x.toDouble(), y.toDouble(), size)
            var isOnFloor = true
            print(peanut.size + " ")
            for (box in boxes) {
                if (peanutIsInBox(peanut, box)) {
                    println(if (peanut.size == box.size) "correct" else box.size)
                    isOnFloor = false
                    break
                }
            }
            if (isOnFloor) println("floor")
        }
        println()
        nBoxes = readLine()!!.toInt()
    }
}

fun peanutIsInBox(peanut: Peanut, box: Box): Boolean = peanut.x in box.x1..box.x2 && peanut.y in box.y1..box.y2

data class Box(val x1: Double, val y1: Double, val x2: Double, val y2: Double, val size: String)

data class Peanut(val x: Double, val y: Double, val size: String)
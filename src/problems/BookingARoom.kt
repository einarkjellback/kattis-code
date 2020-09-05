package problems

fun main() {
    val (r, n) = readLine()!!.split(" ").map {it.toInt()}
    val vacantRooms = BooleanArray(r + 1) { true }
    for (i in 1..n) {
        val room = readLine()!!.toInt()
        vacantRooms[room] = false
    }
    var vacantRoom = 0
    vacantRooms.drop(1).forEachIndexed { i, isVacant ->
        if (isVacant) {
            vacantRoom = i + 1
            return@forEachIndexed
        }
    }
    print(if (vacantRoom != 0) vacantRoom else "too late")
}
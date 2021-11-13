package problems

fun main() {
    var n = readLine()!!.toInt()
    var case = 1
    while (n != 0) {
        val animalCounter = sortedMapOf<String, Int>()
        for (i in 1..n) {
            val animal = readLine()!!
                .split(" ")
                .last()
                .toLowerCase()
            animalCounter.putIfAbsent(animal, 0)
            animalCounter[animal] = animalCounter.getValue(animal) + 1
        }
        println("List $case:")
        animalCounter.forEach { (k, v) -> println("$k | $v")}
        case += 1
        n = readLine()!!.toInt()
    }
}
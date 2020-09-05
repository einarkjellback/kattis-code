package problems

fun main() {
    var input = readLine()!!
    while (input != "0") {
        val (nChosenCourses, nCategories) = input.split(" ").map { it.toInt() }
        val chosenCourses = readLine()!!.split(" ")
        val meetsDegreeReq = (1..nCategories).map { _ ->
            val categoryInfo = readLine()!!.split(" ")
            val nReqCourses = categoryInfo[1].toInt()
            categoryInfo
                .drop(2)
                .toHashSet()
                .filter { it in chosenCourses }
                .size >= nReqCourses
        }.all { it }
        println(if (meetsDegreeReq) "yes" else "no")
        input = readLine()!!
    }
}
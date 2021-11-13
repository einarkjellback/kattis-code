package problems

import java.util.*

fun main() {
    var orders = readLine()!!.toInt()
    while (orders != 0) {
        val orderMap = sortedMapOf<String, SortedSet<String>>()
        for (i in 1..orders) {
            val order = readLine()!!.split(" ")
            val customer = order[0]
            for (food in order.drop(1)) {
                orderMap.putIfAbsent(food, sortedSetOf())
                val names = orderMap.getValue(food)
                names.add(customer)
            }
        }
        for (key in orderMap.keys) {
            print("$key ")
            for (value in orderMap.getValue(key)) print("$value ")
            println()
        }
        println()
        orders = readLine()!!.toInt()
    }
}
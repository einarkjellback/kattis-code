package inf237_2020.adhoc

import kotlin.math.pow

/*
An experience consists of three open slots. These slots contain some number of ingredients, say, | i1 i2 | i1 i3 i4 | i1 |.
Each ingredient can be a number of brands. If the ingredients consist of brands | 3 | 4 | 1 | 5 | then this experience
mounts to the number of combinations for choosing brands for i1 i2 i3 i4 which is 3*4*1*5.
 */

fun main() {
    val readIntList = { readLine()!!.split(" ").map { it.toInt() } }
    val (_, starters, mains, desserts, incompatibles) = readIntList()
    val brands = readIntList()
    val courses = starters + mains + desserts
    val recipes = Array (courses) { readIntList().drop(1).map { it - 1 } }
    val incompatibleDishes = Array (courses) { mutableListOf<Int>() }
    for (i in 0 until incompatibles) {
        val (dishA, dishB) = readIntList().map { it - 1 }
        incompatibleDishes[dishA].add(dishB)
        incompatibleDishes[dishB].add(dishA)
    }

    var combinations = 0L
    outer@for (s in 0 until starters) {
        for (m in starters until starters + mains) {
            if (incompatibleDishes[s].contains(m).not()) {
                for (d in starters + mains until courses) {
                    if (combinations >= 10F.pow(18)) break@outer
                    else if (incompatibleDishes[s].contains(d).not() && incompatibleDishes[m].contains(d).not()) {
                        val ingredientSet = recipes[s].toMutableSet()
                        ingredientSet.addAll(recipes[m])
                        ingredientSet.addAll(recipes[d])
                        combinations += ingredientSet
                            .fold(1) { acc: Long, ingredient -> acc * brands[ingredient] }
                    }
                }
            }
        }
    }
    println(if (combinations >= 10F.pow(18)) "too many" else combinations)
}
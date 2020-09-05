package problems

fun main() {
    val recipes = readLine()!!.toInt()
    for (recipe in 1..recipes) {
        val (ingredients, fromPortions, toPortions) = readLine()!!.split(" ").map { it.toInt() }
        var referenceWeight = 0.0
        val ingredientNames = mutableListOf<String>()
        val relativeAmounts = mutableListOf<Double>()
        for (i in 0 until ingredients) {
            val (ingredientName, absoluteAmount, relativeAmount) = readLine()!!.split(" ")
            ingredientNames.add(ingredientName)
            relativeAmounts.add(relativeAmount.toDouble())
            if (relativeAmount.toDouble() == 100.0) referenceWeight = absoluteAmount.toDouble()
        }
        println("Recipe # $recipe")
        val portionScale = toPortions.toDouble() / fromPortions
        ingredientNames
            .zip(relativeAmounts)
            .forEach { (name, amount) ->
                println("$name " + portionScale * referenceWeight * amount / 100)
            }
        println("----------------------------------------")
    }
}
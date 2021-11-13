package problems

fun main() {
    var input = readLine()
    while (input != null) {
        val domain = input.split(" ").drop(1).toMutableSet()
        val codomain = readLine()!!.split(" ").drop(1).toMutableSet()
        val codomainSize = codomain.size
        val cardinality = readLine()!!.toInt()
        var isFunction = true
        for (transformation in 1..cardinality) {
            val (from, _, to) = readLine()!!.split(" ")
            if (!domain.remove(from)) {
                isFunction = false
                break
            }
            codomain.remove(to)
        }
        if (isFunction) {
            val isInjective = codomain.size + cardinality == codomainSize
            val isSurjective = codomain.isEmpty()
            when {
                isInjective && isSurjective -> println("bijective")
                isInjective -> println("injective")
                isSurjective -> println("surjective")
                else -> println("neither injective nor surjective")
            }
        } else println("not a function")
        input = readLine()
    }
}
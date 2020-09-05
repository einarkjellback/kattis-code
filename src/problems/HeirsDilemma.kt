package problems

fun main() {
    val lo = sequenceOf(1,2,3,4,5,6)
    val hi = sequenceOf(9,8,7,6,5,4)
    val allChoices: Sequence<Sequence<Int>> = genAllChoices((1..9).asSequence())
    print("test")
    var count = 0
    allChoices.forEach {
        val allPermutations = genAllPermutations(it, sequenceOf())
        allPermutations.forEach { perm ->
            if (isInRange(perm, lo, hi) && isDivisibleByDigits(
                    perm
                )
            ) count += 1
        }
    }
    print(count)
}

fun isInRange(n: Sequence<Int>, lo: Sequence<Int>, hi: Sequence<Int>): Boolean {
    val n = n.joinToString("").toInt()
    val lo = lo.joinToString("").toInt()
    val hi = hi.joinToString("").toInt()
    return n in lo..hi
}

fun genAllPermutations(selection: Sequence<Int>, acc: Sequence<Int>): Sequence<Sequence<Int>> {
    if (selection.count() == 0) {
        return sequenceOf(acc)
    }
    val e = selection.first()
    val toReturn = sequenceOf<Sequence<Int>>()
    toReturn.plus(
        genAllPermutations(
            selection.drop(1),
            sequenceOf(e).plus(acc)
        )
    )
    toReturn.plus(
        genAllPermutations(
            selection.drop(1),
            acc.plusElement(e)
        )
    )
    return toReturn
}

fun genAllChoices(selection: Sequence<Int>): Sequence<Sequence<Int>> {
    var acc: Sequence<Sequence<Int>> = sequenceOf()
    if (selection.count() == 6) acc = acc.plusElement(selection)
    else {
        for (i in 0..selection.count()) {
            acc = acc.plus(genAllChoices(selection.take(i).plus(selection.drop(i + 1))))
        }
    }
    return acc
}

fun isDivisibleByDigits(n: Sequence<Int>): Boolean {
    return n.all { i ->
        n.zip(sequenceOf(1, 2*5, 4*5, 8*5, 8*5, 8*5)) {fst, snd -> fst * snd }
            .all {it % i == 0}
    }
}

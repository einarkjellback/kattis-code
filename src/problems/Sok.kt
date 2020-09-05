package problems


fun main() {
    val juices = readLine()!!.split(" ").map { it.toDouble() }
    val ratios = readLine()!!.split(" ").map { it.toDouble() }
    val minLitres = juices
        .zip(ratios) {j, r -> j / r }
        .min()!!
    print(juices.zip(ratios) {j, r -> j - r * minLitres}.joinToString(" "))
}
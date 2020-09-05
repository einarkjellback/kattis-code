package problems

fun main() {
    val newSymbols = listOf("@", "8", "(", "|)", "3", "#", "6","[-]","|","_|","|<","1","[]\\/[]","[]\\[]","0","|D","(,)","|Z","$","']['","|_|","\\/","\\/\\/","}{","`/","2")
    val newAlphabetMap = ('a'..'z').zip(newSymbols).toMap()
    print(readLine()!!
        .toCharArray()
        .map { it.toLowerCase() }
        .joinToString("") { newAlphabetMap.getOrDefault(it, it.toString()) }
    )
}
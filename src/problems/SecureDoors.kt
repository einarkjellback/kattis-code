package problems

fun main() {
    val logEntries = readLine()!!.toInt()
    val isInside = mutableMapOf<String, Boolean>()
    for (logEntry in 1..logEntries) {
        val (dir, name) = readLine()!!.split(" ")
        val isEntry = dir == "entry"
        var str = name.plus(if (isEntry) " entered" else " exited")
        if (isEntry.xor(isInside.getOrDefault(name, false)).not()) {
            str = str.plus(" (ANOMALY)")
        }
        isInside[name] = isEntry
        println(str)
    }
}
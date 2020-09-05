package inf237_2020.graphs1

fun main() {
    var input = readLine()
    var case = 1
    while (input != null) {
        val (nodes, edges) = input.split(" ").map { it.toInt() }
        val graph = List(nodes) { mutableSetOf<Int>() }
        val edgeList = MutableList(edges) {
            val (from, to) = readLine()!!.split(" ").map { it.toInt() }
            graph[from].add(to)
            Edge(from, to)
        }

        val strongComponentsGraph = decomposeToStrongComponents(graph)
        var output = "Case $case: "
        if (strongComponentsGraph.size == 1) {
            output += "valid"
        } else {
            val sourceNodeCount = countSourceNodes(strongComponentsGraph)
            val sinkNodeCount = countSinkNodes(strongComponentsGraph)
            val sourceNodeEdges = strongComponentsGraph.last().second
            if (sourceNodeCount > 1 || sinkNodeCount > 1 || sourceNodeEdges.size < 2 || !sourceNodeEdges.contains(0)) {
                output += "not valid"
            } else {
                edgeList.forEach { (from, to) ->
                    val sourceNodeSet = strongComponentsGraph.last().first
                    if (sourceNodeSet.contains(from) && sourceNodeEdges.contains(to)) {
                        output += "$from $to"
                        return@forEach
                    }
                }
            }
        }
        println(output)
        input = readLine()
        case += 1
    }
}

fun <T> countSinkNodes(strongComponentsGraph: List<Pair<T, Set<Int>>>): Int {
    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
}

fun <T> countSourceNodes(strongComponentsGraph: List<Pair<T, Set<Int>>>): Int {
    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
}

/**
 * Decomposes a graph into its strongly connected components. The first set are the nodes in component i and the second
 * set are the edges from component i to component j. The first node is always a sink and the last one always a source.
 */
fun decomposeToStrongComponents(graph: List<Set<Int>>): List<Pair<Set<Int>, Set<Int>>> {
    // TODO
    return listOf((Pair(setOf(), setOf())))
}

fun dfs(current: Int, visited: Array<Boolean>, nodesLeft: Int, graph: List<Set<Int>>): Boolean {
    if (nodesLeft == 0) return true
    if (visited[current]) return false
    visited[current] = true
    var visitedAll = false
    for (to in graph[current]) {
        visitedAll = visitedAll || dfs(to, visited, nodesLeft - 1, graph)
    }
    return visitedAll
}

data class Edge(val from: Int, val to: Int)
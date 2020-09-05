package problems


/*
Sort points by x-coordinate
Store the distances between subsequent points (divided by 2 and then ceil) and the edge of the board if applicable
Repeat for y-coordinates
For each point: Find the diagonal manhattan distances
Return the highest such number

Time complexity = O(nlog(n))
Sorting is O(nlog(n))
The rest are just linear stuff.
 */

fun main() {

}

data class Point(var x: Int, var y: Int) {
    constructor(coordinates: List<Int>) : this(coordinates[1], coordinates[0])
}


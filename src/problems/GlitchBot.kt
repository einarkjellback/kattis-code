package problems

import kotlin.math.abs

fun main() {
    data class Pos(val x: Int, val y: Int)
    val (destX, destY) = readLine()!!.split(" ").map { it.toInt() }
    val finalDest = Pos(destX, destY)
    val nInstructions = readLine()!!.toInt()
    var dx = 0
    var dy = 0
    var x = 0
    var y = 0
    val instructions = (1..nInstructions).map { readLine()!!.first() }
    val computeFinalDest = { instructions: List<Char> ->
        instructions.fold(Pair('N', Pos(0, 0))) { acc, v ->
            val dir = acc.first
            val pos = acc.second
            when (v) {
                'F' -> {
                    val y = pos.y
                    val x = pos.x
                    val newPos = when (dir) {
                        'N' -> Pos(x, y + 1)
                        'E' -> Pos(x + 1, y)
                        'S' -> Pos(x, y - 1)
                        else -> Pos(x - 1, y)
                    }
                    Pair(dir, newPos)
                }
                else -> {
                    val goRight = { instruction: Char ->
                        when (instruction) {
                            'N' -> 'E'
                            'E' -> 'S'
                            'S' -> 'W'
                            else -> 'N'
                        }
                    }
                    when (v) {
                        'R' -> Pair(goRight(dir), pos)
                        else -> Pair((1..3).fold(dir) { dir, _ -> goRight(dir) }, pos)
                    }
                }
            }
        }
    }
    val totDistWalked = instructions.count { it == 'F' }
    val distFromDest = abs(destX) + abs(destY)
    var correctionToInstruction = Pair(0, 'A')
    if (totDistWalked - distFromDest == -1) {
        for (i in instructions.indices) {
            val c = instructions[i]
            if (c == 'R' || c == 'L') {
                val newInstructions = instructions.take(i) + 'F' + instructions.drop(i + 1)
                if (computeFinalDest(newInstructions).second == finalDest) {
                    correctionToInstruction = Pair(i + 1, 'F')
                    break
                }
            }
        }
    } else if (totDistWalked - distFromDest == 0) {
        for (i in instructions.indices) {
            val c = instructions[i]
            val newInstructions = instructions.take(i) +
                    (if (c == 'R') 'L' else 'R') +
                    instructions.drop(i + 1)
            if (computeFinalDest(newInstructions).second == finalDest) {
                correctionToInstruction = Pair(i + 1, instructions[i])
                break
            }
        }
    } else {
        for (i in instructions.indices) {
            val c = instructions[i]
            if (c == 'F') {
                var newInstructions = instructions.take(i) + 'R' + instructions.drop(i + 1)
                if (computeFinalDest(newInstructions).second == finalDest) {
                    correctionToInstruction = Pair(i + 1, 'R')
                    break
                }
                newInstructions = instructions.take(i) + 'L' + instructions.drop(i + 1)
                if (computeFinalDest(newInstructions).second == finalDest) {
                    correctionToInstruction = Pair(i + 1, 'L')
                    break
                }
            }
        }
    }
    val (atLine, instruct) = correctionToInstruction
    println("$atLine " + if (instruct == 'F') "Forward" else if (instruct == 'R') "Right" else "Left")
}


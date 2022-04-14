import Problem

fun main() = solve { Problem002() }

class Problem002 : Problem<Int>(
    problem = 2
) {
    override val input = rawInput

    override fun solveProblem(): Int {
        return generateSequence(Pair(0, 1)) { Pair(it.second, it.first + it.second) }.map { it.first }
            .takeWhile { it < 4000000 }.filter { it % 2 == 0 }.sum()
    }
}
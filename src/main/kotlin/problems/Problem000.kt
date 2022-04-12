import Problem

fun main() = solve { Problem000() }

class Problem000 : Problem<Int>(
    problem = 0
) {
    override val input = rawInput

    override fun solveProblem(): Int {
        return 0
    }
}
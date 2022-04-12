import utils.gauss

fun main() = solve { Problem001() }

class Problem001 : Problem<Int>(
    problem = 1
) {
    override val input = rawInput

    override fun solveProblem(): Int {
        val limit = 999
        val threes = 3 * (gauss(limit/3))
        val fives = 5 * (gauss(limit/5))
        val fiddy = 15 * (gauss(limit/15))
        return threes + fives - fiddy
    }
}
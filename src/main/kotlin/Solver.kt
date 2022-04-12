import java.nio.file.Files
import java.nio.file.Paths

fun <T : Any> solve(block: () -> Problem<T>) {
    printResult(block)
}

fun getInput(problem: Int): List<String>? {
    val resource = "input/problem$problem.in"
    return Problem::class.java.classLoader?.getResource(resource)
        ?.toURI()
        ?.let { Paths.get(it) }
        ?.let { Files.readAllLines(it) }
}

fun <T : Any> printResult(block: () -> Problem<T>) {
    val problem = block()
    println("Problem ${problem.problem}".bold())
    val problemResult = problem.solveProblem().bold("36")
    println("Result: $problemResult")
}

private fun Any.bold(color: String = ""): String = style("$color;1")

private fun Any.style(color: String): String {
    return "\u001B[${color}m$this\u001B[0m"
}
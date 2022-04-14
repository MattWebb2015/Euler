import java.math.BigInteger

fun main() = solve { Problem700() }

class Problem700 : Problem<BigInteger>(
    problem = 700
) {
    override val input = rawInput
    val eulermod = 4503599627370517L.toBigInteger()
    val eulerquotient = 1504170715041707L.toBigInteger()

    override fun solveProblem(): BigInteger {
        val coinbase = mutableSetOf<BigInteger>(eulerquotient)
        var n = BigInteger.ONE
        var m = BigInteger.ONE
        var modu = eulermod
        val inverse = eulerquotient.modInverse(eulermod)
        while (eulercoins(n) != BigInteger.ZERO) {
            val i = eulercoins(n)
            if (i < coinbase.minByOrNull { it }!!) {
                modu = i
                coinbase.add(i)
                println("$n : $i")
            }
            n++
            if (i <= n) {
                var ceiling = eulermod
                while (m < i) {
                    modu = (inverse * m).mod(eulermod)
                    if (modu < ceiling) {
                        ceiling = modu
                        coinbase.add(m)
                        println("$m")
                    }
                    m++
                }
                break
            }
        }
        return coinbase.sumOf { it }
    }

    private fun eulercoins(num: BigInteger): BigInteger {
        return ((eulerquotient * num).mod(eulermod))
    }

}
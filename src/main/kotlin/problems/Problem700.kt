import java.math.BigInteger

fun main() = solve { Problem700() }

class Problem700 : Problem<BigInteger>(
    problem = 700
) {
    override val input = rawInput

    override fun solveProblem(): BigInteger {
        val coinbase = mutableSetOf<BigInteger>(1504170715041707L.toBigInteger())
        var n = BigInteger.ONE
        var m = BigInteger.ONE
        var modu = 4503599627370517L.toBigInteger()
        val inverse = 1504170715041707.toBigInteger().modInverse(4503599627370517L.toBigInteger())
        while (eulercoins(n) != BigInteger.ZERO) {
            val i = eulercoins(n)
            if (i < coinbase.minByOrNull { it }!!) {
                modu = i
                coinbase.add(i)
                println("$n : $i")
            }
            n++
            if (i <= n) {
                var ceiling = 4503599627370517L.toBigInteger()
                while (m < i) {
                    modu = (inverse * m).mod(4503599627370517L.toBigInteger())
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
        return ((1504170715041707L.toBigInteger() * num).mod(4503599627370517L.toBigInteger()))
    }

}
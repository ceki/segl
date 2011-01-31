package gt201101

/**
 * @author Ceki G&uuml;c&uuml;
*/
import collection.mutable.ListBuffer
     
object ImperativeEuler7 {
  var primes = List(2)
  val limit = 10001;

  def initPrimeList() = {
    var i: Int = 3
    while (primes.length < limit) {
      if (isPrime(i))
        primes += i
      i += 2
    }
  }

  def isPrime(n: Int): Boolean = {
    for (p <- primes) {
      if (n % p == 0) return false
      if (p * p > n) return true
    }
    throw new IllegalStateException("failed to determine primality of [" + n + "]" + primes)
  }

  // runs in about 1.2 seconds
  def main(args: Array[String]) = {
     val s = System.currentTimeMillis
    initPrimeList
    assert (104743== primes.last)
    println(""+(System.currentTimeMillis-s))

  }
}
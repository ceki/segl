package gt201101

import collection.mutable.ListBuffer

/**
 * @author Ceki G&uuml;c&uuml;
*/
     
object ImperativeEuler7 {
  val primes :ListBuffer[Int] = ListBuffer(2)
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

  // runs in about 55 milliseconds
  def main(args: Array[String]) = {
     val s = System.currentTimeMillis
    initPrimeList
    assert (104743== primes.last)
    println("exect time "+(System.currentTimeMillis-s) + " in ms")

  }
}
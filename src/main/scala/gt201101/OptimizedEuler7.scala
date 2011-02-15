package gt201101

/**
 * @author Ceki G&uuml;c&uuml;
*/   
     
object OptimizedEuler7 {

  def ceilSqrt(n: Int): Int = {
    var sqrtN: Int = math.sqrt(n).toInt
    while(sqrtN*sqrtN <= n) sqrtN += 2
    sqrtN
  }

  def isPrime(n: Int) : Boolean = {
    if( n == 2) return  true
    if( n % 2 == 0) return false
    !(new Range(3, ceilSqrt(n), 2) exists( n % _ == 0))
  }

  def next(n: Int): Stream[Int] = Stream.cons(n, next(n + 2))
  val primeCandidateStream: Stream[Int] = Stream.cons(2, next(3))

  def compute10001thPrime(): Int = {
    primeCandidateStream.filter(isPrime).take(10001).last
  }

  // runs in 111 milliseconds
 def  main(args: Array[String]) = { assert(104743 == compute10001thPrime) }
}
package gt201101

/**
 * @author Ceki G&uuml;c&uuml;
*/   
     
object IdiomaticEuler7 {

  def isPrime(n: Int) : Boolean = {!(2 until n exists( n % _ == 0)) }

  def next(n: Int): Stream[Int] = Stream.cons(n, next(n + 1))
  val primeCandidateStream: Stream[Int] = Stream.cons(2, next(3))

  def compute10001thPrime(): Int = {
    val nonFiltered = primeCandidateStream.filter(a => {println(a);true})
    println("last="+nonFiltered.take(10001).last)

    val filteredStream = primeCandidateStream.filter((i:Int) => {println(i);isPrime(i)})
    println("filtered")
    filteredStream.take(10001).last
  }


  // runs in about 18 seconds
 def  main(args: Array[String]) = { assert (104743 == compute10001thPrime) }
}
package gt201102

/**
 * Created by IntelliJ IDEA.
 * User: hub
 * Date: 22/02/11
 * Time: 19:45
 * Hubert's attempt to solve it using FP
 * http://projecteuler.net/index.php?section=problems&id=11
 */

object HubertEuler11 {

  // Find the greatest product of four number in a row in whatever direction inside
  // a 20x20 matrix.
  val ex11Grid = """
08 02 22 97 38 15 00 40 00 75 04 05 07 78 52 12 50 77 91 08
49 49 99 40 17 81 18 57 60 87 17 40 98 43 69 48 04 56 62 00
81 49 31 73 55 79 14 29 93 71 40 67 53 88 30 03 49 13 36 65
52 70 95 23 04 60 11 42 69 24 68 56 01 32 56 71 37 02 36 91
22 31 16 71 51 67 63 89 41 92 36 54 22 40 40 28 66 33 13 80
24 47 32 60 99 03 45 02 44 75 33 53 78 36 84 20 35 17 12 50
32 98 81 28 64 23 67 10 26 38 40 67 59 54 70 66 18 38 64 70
67 26 20 68 02 62 12 20 95 63 94 39 63 08 40 91 66 49 94 21
24 55 58 05 66 73 99 26 97 17 78 78 96 83 14 88 34 89 63 72
21 36 23 09 75 00 76 44 20 45 35 14 00 61 33 97 34 31 33 95
78 17 53 28 22 75 31 67 15 94 03 80 04 62 16 14 09 53 56 92
16 39 05 42 96 35 31 47 55 58 88 24 00 17 54 24 36 29 85 57
86 56 00 48 35 71 89 07 05 44 44 37 44 60 21 58 51 54 17 58
19 80 81 68 05 94 47 69 28 73 92 13 86 52 17 77 04 89 55 40
04 52 08 83 97 35 99 16 07 97 57 32 16 26 26 79 33 27 98 66
88 36 68 87 57 62 20 72 03 46 33 67 46 55 12 32 63 93 53 69
04 42 16 73 38 25 39 11 24 94 72 18 08 46 29 32 40 62 76 36
20 69 36 41 72 30 23 88 34 62 99 69 82 67 59 85 74 04 36 16
20 73 35 29 78 31 90 01 74 31 49 71 48 86 81 16 23 57 05 54
01 70 54 71 83 51 54 69 16 92 33 48 61 43 52 01 89 19 67 48
"""
  def str2Matrix(s: String) = {
    val ls = io.Source.fromString(ex11Grid).getLines
    val ia = for (l <- ls; if l.length>0) yield l.split(" ").map(_.toInt)
    ia.toArray
  }

  lazy val matrix  = str2Matrix(ex11Grid)

  /**
   * takes a Tuple2[Int, Int] (or (Int, Int) or a position for the rest of this code)
   * and returns the corresponding value in the matrix.
   */
  def m(p: (Int, Int)) = matrix(p._1)(p._2)

  // pimp (Int, Int) with Point methods.
  implicit def pairIntInt2Point(p: (Int, Int)) = Point(p)

  case class Point(p: (Int, Int)) {

    /** apply a vector v to a point returning the new position.*/
    def +(v: (Int, Int)) = (p._1 + v._1, p._2 + v._2)

    /** collect in a List the passed point p plus the resulting points applying vector v n times.*/
    private def collect(p: (Int, Int), v: (Int, Int), n: Int) = {

      @scala.annotation.tailrec
      def _collect(l: List[(Int, Int)], v: (Int, Int), n: Int): List[(Int, Int)] =
        if (n == 0) l else _collect((l.head + v) :: l, v, n - 1)

      _collect(p :: Nil, v, n)
    }

    /** collect p and the three adjacent points vertically (downward).*/
    def | = collect(p, (1, 0), 3)

    /** collect p and the three adjacent points diagonally (downward).*/
    def \ = collect(p, (1, 1), 3)

    /** collect p and the three adjacent points antidiagonally (http://goo.gl/Oi1Q1)(downward).*/
    def / = collect(p, (1, -1), 3)

    /** collect p and the three adjacent points horizontally (rightward).*/
    def - = collect(p, (0, 1), 3)
  }

  /**
   * collect all the relevant radial segments of positions starting from p.
   * This function is meant to be used on positions of a 20x20 matrix, ie (0, 0) to (19, 19).
   * If you pass all possible positions, you will have covered the complete matrix.
   */
  def segments(p: (Int, Int)) = p match {
    case (i, j) if i > 16 && j > 16 => Nil
    case (i, _) if i > 16           => p.- :: Nil
    case (_, j) if j < 3            => p.| :: p.\ :: p.- :: Nil
    case (_, j) if j > 16           => p./ :: p.| :: Nil
    case _                          => p./ :: p.| :: p.\ :: p.- :: Nil
  }

  def main(args: Array[String]) = {
    val allPos = for (i <- 0 to 19; j <- 0 to 19) yield (i, j)
    val sol = allPos flatMap segments map { _.foldLeft(1) { (a, b) => a * m(b) } } reduceLeft math.max
    println("The solution for Euler 11 problem is " + sol)
  }
}
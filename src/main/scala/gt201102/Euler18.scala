package gt201102

import io.Source

/**
 * User: Rolf Jordi
 * Date: 2/14/11
 * Time: 10:03 PM
 */

class Euler18(value: Int, previous: Euler18) {
  val max = getMax()

  def this(value: Int) = this (value, null)

  def getMax(): Int =
    if (previous != null)
      previous.max + value
    else
      value

  def getMaxChild(): List[Euler18] =
    if (value == max)
      Nil
    else
      previous.getMaxPath

  def getMaxPath(): List[Euler18] = this :: getMaxChild

  def max(that: Euler18): Euler18 =
    if (this.max > that.max)
      this
    else
      that

  override def toString = value.toString
}

object Euler18 {
  def main(args: Array[String]) = {

    val inputStream = classOf[Euler18].getResourceAsStream("/euler18.txt")
    val test = Source.fromInputStream(inputStream).getLines.toArray.reverse
    var start = System.currentTimeMillis

    var previousList2: IndexedSeq[Int] = for (element <- test(0).trim.split(" ")) yield element.toInt;
    start = System.currentTimeMillis
    for (line <- test.tail) {
      val list = for (element <- line.trim.split(" ")) yield element.toInt;
      previousList2 = for (i <- 0 to list.length - 1) yield
        math.max(previousList2(i), previousList2(i + 1)) + list(i)

    }
    println("finish time " + (System.currentTimeMillis - start) + " ms")
    println("max may be:" + previousList2(0))

    //remove var test
    start = System.currentTimeMillis
    def euler18Solve(previousList: IndexedSeq[Euler18], lines: Array[String]): IndexedSeq[Euler18] = {

      if (lines.length == 0)
        return previousList

      val list = for (element <- lines.head.trim.split(" ")) yield element.toInt;
      val currentList = for (i <- 0 to list.length - 1) yield {
        if (previousList == null)
          new Euler18(list(i))
        else
          new Euler18(list(i), previousList(i).max(previousList(i + 1)))
      }
      euler18Solve(currentList, lines.tail)
    }
    println("result: " + euler18Solve(null, test).head.max)
    println("finish time " + (System.currentTimeMillis - start) + " ms")
    println("path is" + euler18Solve(null, test).head.getMaxPath)

  }
}


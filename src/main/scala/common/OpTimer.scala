package common



trait OpTimer {

  def time(op: () => Unit) = {
    val start = System.currentTimeMillis
    op()
    val end = System.currentTimeMillis
    end-start
  }

  def timeAndPrint(op: () => Unit) = {
    val millis = time(op)
    println("Operation completed in "+millis+" milliseconds")
  }
}
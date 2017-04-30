import scala.annotation.tailrec

/**
  * Different ways to calculate the sum of a list using
  * recursive Scala methods.
  */
object Sum extends App {

  val list = List.range(1, 100000)
  //println(sum(list)) // -- will throw stackoverflow
  println(sum2(list))

  // (1) yields a "java.lang.StackOverflowError" with large lists
  // @tailrec - will not compile
  def sum(ints: List[Int]): Int = ints match {
    case Nil => 0
    case x :: tail => x + sum(tail)
  }

  // (2) tail-recursive solution
  def sum2(ints: List[Int]): Int = {
    @tailrec
    def sumAccumulator(ints: List[Int], accum: Int): Int = {
      ints match {
        case Nil => accum
        case x :: tail => sumAccumulator(tail, accum + x)
      }
    }
    sumAccumulator(ints, 0)
  }

}

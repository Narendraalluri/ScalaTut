object Currying extends App {
  val add = (x:Int, y:Int) => x + y
  def curryAdd (x: Int)(y: Int): Int = {
    x + y
  }
  val add2 = curryAdd(2) _
  val add3 = curryAdd(3) _
  println(add2(3))
  println(add3(3))
}

//Partially applied functions
object PartiallyAppliedFunction extends App{
  val add = (x:Int, y:Int) => x + y
  val add2 = add(2, _: Int)
  println(add2(3))
}

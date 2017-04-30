import scala.collection.mutable

// Using main method
object ApplicationUsingMain {
  def main(args: Array[String]): Unit = {
    println("Hello World!")
  }
}

// Using App
object ApplicationUsingApp extends App {
  print("Hello World")
}

//Arrays
object Arrays extends App {
  val array = Array("dfg", "sdfsf", "sfsdf")
  println(array(2))
}

//Functional Composition
object FunComp extends App {
  val f = (x: Int) => x * 2
  val g = (x: Int) => x - 1
  val fAndThenG = f andThen g
  println(fAndThenG(6))
}

//List
object Lists extends App {

  val list = List("sdfsfaa", "sdaa")
  println(list.map(x => x + 1))
  println(list map (x => x + 1) )
  val list1 = List("sdfsf", 1)
  println(list ::: list1)
}

//Tuple
object Tuples extends App {
  val tuple = ("sdfs", 1, "sdfsd", "sdfsdf")
  println(tuple._1.charAt(0))
}

//Set
object SetTest extends App {
  val set = Set("sdf", "sdfsd")
  println(set + "sdfsdfsdfsdf")
  println(set)
}

//Map
object MapTest extends App {
  val map = Map[Int, String]()

  println(map + (1 -> "sdf"))
  println(map)

  val mutableMap = mutable.Map[Int, String]()
  mutableMap += (1 -> "sdfsdf")
  println(mutableMap)

}

//List, first class functions, wildcard, asserts, == vs eq, option
object ListTest extends App {
  val someNumbers = List(1, 2, 3, 4)
  val moreNumbers = List(5, 6, 7, 8)
  assert(someNumbers.head == 1)
  assert(someNumbers.tail == List(2, 3, 4))
  assert(!(someNumbers.tail eq List(2, 3, 4)))
  assert(someNumbers.map(x => x + 1) == List(2, 3, 4, 5))
  assert(someNumbers.filter(_ > 2) == List(3, 4))
  assert(someNumbers.take(2) == List(1, 2))
  assert(someNumbers.drop(2) == List(3, 4))
  assert(someNumbers.dropRight(2) == List(1, 2))
  assert(someNumbers ::: moreNumbers == List(1, 2, 3, 4, 5, 6, 7, 8))
  assert(0 :: moreNumbers == List(0, 5, 6, 7, 8))
  assert(0 +: moreNumbers == List(0, 5, 6, 7, 8))
  assert(someNumbers ++ moreNumbers == List(1, 2, 3, 4, 5, 6, 7, 8))
  assert(someNumbers == List(1, 2, 3, 4))
  assert(moreNumbers == List(5, 6, 7, 8))
  assert(someNumbers.map(_ + 2).filter(_ > 10).headOption == None)
  assert(someNumbers.map(_ + 2).filter(_ > 10).headOption != Some)
  assert(someNumbers.map(_ + 2).filter(_ > 2).head == 3)
}

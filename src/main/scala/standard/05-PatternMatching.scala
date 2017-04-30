import MatchTest1.matchTest

//simple pattern matching
object MatchTest1{
  def matchTest(x: Int): String = x match {
    case 1 => "one"
    case 2 => "two"
    case _ => "many"
  }
}

object PatternMatching extends App {
  println(matchTest(3))
}

//sealed traits
sealed trait Message { def msg: String }
case class Success(msg:String) extends Message
case class Failure(msg:String) extends Message
//case class Pending(msg:String) extends Message

object MessageHandler extends App {

  def log(msg: Message) = msg match {
    case Success(str) => println("Success: " + str)
    case Failure(str) => println("Failure: " + str)
  }

  log(Success("sdfdsf"))
}



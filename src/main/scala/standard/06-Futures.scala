import scala.concurrent.{Await, Future}
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.duration._
import scala.language.postfixOps

object Futures extends App {

  val fileRead: Future[String] = Future {
    val source = scala.io.Source.fromFile("src/WhyScala.txt")
    //source.getLines().reduceLeft((z, memo) => memo + z)
    source.getLines().reduceLeft(_  + _)
  }

  fileRead onComplete {
    case txt => println(txt)
  }

  Await.ready(fileRead, 60 seconds)

}

object FutureForComprehension {
//  val usdQuote = Future { connection.getCurrentValue(USD) }
//  val chfQuote = Future { connection.getCurrentValue(CHF) }
//
//  val purchase = for {
//    usd <- usdQuote
//    chf <- chfQuote
//    if isProfitable(usd, chf)
//  } yield connection.buy(amount, chf)
//
//  purchase onSuccess {
//    case _ => println("Purchased " + amount + " CHF")
//  }
}

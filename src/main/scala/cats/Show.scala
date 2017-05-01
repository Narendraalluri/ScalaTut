package catstut

import cats._
import cats.implicits._


object ShowTutorial extends App {

  implicit val personShow = Show.show[Person](_.name)
  println(Person("Alice").show)
}

package catstut

import cats.functor.Bifunctor
import catstut.TupleTest.IntTuple


case class Person(name: String)

object ShowAndEQTutorial extends App {
  import cats._
  import cats.implicits._
  //println(1 === "1") : does not compile
  println(1 == "1")
  implicit val personShow = Show.show[Person](_.name)
  println(Person("Alice").show)
}

object FunctorMain extends App {
  import cats._
  import cats.implicits._
  println(Functor[List].map(List(1, 2, 3))(_ + 1))
  println(List(1, 2, 3).map(_ + 1))
  println(Some(1).map(_ + 1))
  println(Functor[Option].map(Some(1))(_ + 1))
  println(Functor[List].fproduct(List("sdf", "sdfsdfs"))(_.length).toMap)
  (Left("boom!"): Either[String, Int]) map { _ + 1 }

}

object TupleTest extends App {

    type IntTuple[A]=(Int, A)

    implicit val tuple2Functor = new cats.Functor[IntTuple] {
      override def map[B, C](fa: IntTuple[B])(f: B => C): IntTuple[C] =
        (fa._1, f(fa._2))
    }

  println(cats.Functor[IntTuple].map((1, 2))(a => a + 1)) // (1, 3)

}

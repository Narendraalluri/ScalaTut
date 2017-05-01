package catstut

import scala.language.implicitConversions

case class Person(name: String)



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

  type CustomTuple[+A]=(Any, A)

  implicit val tuple2Functor = new cats.Functor[CustomTuple] {
    override def map[B, C](fa: CustomTuple[B])(f: B => C): CustomTuple[C] =
      (fa._1, f(fa._2))
  }

  println(cats.Functor[CustomTuple].map((1, 2))(_ + 1))

  class OPS[A](x:CustomTuple[A])(implicit itf: cats.Functor[CustomTuple]) {
    def map[C](f: A => C): CustomTuple[C] = itf.map(x)(f)
  }

  implicit def convertor[X]( SX: CustomTuple[X]): OPS[X] =
    new OPS[X](SX)

  println((1, 2) map (_ + 1))
}

object FunctorCompose extends App{

  import cats._
  import cats.implicits._

  val list = List(1, 2, 3)
  println(Functor[List].map(list)(_ + 1))
  val option = Some(1)
  println(Functor[Option].map(option)(_ + 1))


  val optionsList = List(Some(1), None, Some(3))

  println(Functor[List].compose[Option].map(optionsList)(_ + 1))

}

package simulacrumtest

import simulacrum._

@typeclass trait Adder[A] {
  @op("|+|") def add(x: A, y: A): A
}

object Adder{
  def toAdder[A](f: (A, A) => A): Adder[A]= new Adder[A] {
    override def add(x: A, y: A)= f(x, y)
  }
}


object Simulacrum extends App{

  import Adder.ops._

  implicit val intAdder: Adder[Int] = Adder.toAdder((x, y) => x + y)
  implicit val stringAdder: Adder[String] = Adder.toAdder((x, y) => x + y)

  println(1 |+| 2)
  println("1" |+| "2")

}

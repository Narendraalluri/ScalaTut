package shapeless
import shapeless._
import nat._
import ops.hlist._
case class User(name: String)

object HListMain extends App{
  val product = "Sunday" :: 1 :: false :: "" :: HNil

  val i :: s :: u :: f :: HNil = product
  case class User1(name: String, age: Int, flag:Boolean, str: String)
  val gen1 = Generic[User1]

  println(gen1.to(User1("Sunday", 1, false, "")))
  println(s"from - ${gen1.from(product)}")

  List("1", "2")(1).substring(0)

  object plusOne extends Poly1 {
    implicit def caseInt =
      at[Int]{ _ + 1 }

    implicit def caseString =
      at[String]{ _ + 1 }

    implicit def caseBool =
      at[Boolean]{ !_ }

    implicit def caseUser =
      at[User]{ case User(name) =>
        User(name + 1)
      }

  }

  println(product.map(plusOne))


  case class UserWithAge(name: String, age: Int)
  val gen = Generic[UserWithAge]
  val ju = UserWithAge("Julien", 30)

  val h = gen.to(ju) // returns Julien :: 30 :: HNil
  println(gen.from(h)) // return UserWithAge("Julien", 30)
}

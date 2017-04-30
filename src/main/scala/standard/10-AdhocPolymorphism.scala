import simulacrumtest.Adder

trait Adder[A] {
  def add(x: A, y: A): A
}

object Adder{
  def toAdder[A](f: (A, A) => A): Adder[A]= new Adder[A] {
    override def add(x: A, y: A)= f(x, y)
  }
}

object AdhocPolymorphism extends App {

  implicit val intAdder: Adder[Int] = Adder.toAdder((x, y) => x + y)
  implicit val stringAdder: Adder[String] = Adder.toAdder((x, y) => x + y)

  def combine[A](x: A, y: A)(implicit adder: Adder[A]): A =
    adder.add(x, y)

  combine(1, 2)
  combine("1", "2")

  case class Person(name:String, age: Int)

  //combine(cats.Person("1", 1), cats.Person("2", 2)) : Won't Compile

  implicit object PersonAdder extends Adder[Person] {
    override def add(x: Person, y: Person): Person = Person(x.name + y.name, x.age + y.age)
  }

  println(combine(Person("1", 1), Person("2", 2)))
}

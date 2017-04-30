import ClassesTutorial._

object ClassesTutorial {

  class Calculator {
    val brand = "HP"
    var model = "model1"
    def add(m: Int, n: Int): Int = m + n
    private def substract(m: Int, n: Int): Int = m - n
  }

  //with constructor
  class CalculatorWithConstructor(val brand: String, var model: String)

  //inheritance
  class ScientificCalculator(brand: String, model: String) extends CalculatorWithConstructor(brand, model) {
    def log(m: Double, base: Double) = math.log(m) / math.log(base)
  }

  //with getters and setters
  class WithGettersAndSetters {
    private var _age:Int = 0
    def age = _age //getter
    def age_= (setAge: Int) = { //setter
      _age = setAge
    }
  }

  //case class -> generates equals and toString by default
  case class Email(sourceEmail: String, title: String, body: String)

  //CompanionObject - static methods
  class CompanionObject {
    val x = "sdf"
  }
  object CompanionObject {
    def multiply = (x: Int, y: Int) => x * y
  }
}



object ClassesMain extends App {
  val calculator = new Calculator
  println(calculator.brand)
  println(calculator.model)
  println(calculator.add(1, 2))
  //println(calculator.subtract(2, 1)) //- will not compile
  //calculator.brand = "s" //- will not compile
  calculator.model = "model2"


  val calculatorWithConstructor = new CalculatorWithConstructor("s", "s")
  val calculatorWithConstructor1 = new CalculatorWithConstructor("s", "s")
  println(calculatorWithConstructor.brand)
  calculatorWithConstructor.model = "sdfs"
  //calculatorWithConstructor.brand = "sdfs" //wont compile

  val withGettersAndSetters = new WithGettersAndSetters()
  withGettersAndSetters.age = 10

  val email1 = new Email("email", "title", "body")
  val email2 = new Email("email", "title", "body")
  val email3 = new Email("email1", "title", "body")

  println(email1 == email2)
  println(calculatorWithConstructor == calculatorWithConstructor1)
  println(email1 == email3)

  println(email1.toString)
  println(calculatorWithConstructor.toString)

  println(CompanionObject.multiply(2,3))
  println(new CompanionObject().x)
}


object Implicits extends App {

  implicit val x:String = "ssd"
  //implicit val z:String = "ssd" // -- ambiguous implicits

  //implcit parameters
  def concat(y: String)(implicit x:String): String = {
    y + x
  }

  println(concat("sdfsdf->"))


  //implicit conversion - implicit function with one parameter will be used as convertor
  implicit val numberToString = (x: Int) => s"00${x}"

  val hello = (s: String) => s"Hello ${s}"

  println(hello("7"))
  println(hello(7))

  {
    import scalaz._, Scalaz._
    println(implicitly[Functor[Tuple1]])
  }
}

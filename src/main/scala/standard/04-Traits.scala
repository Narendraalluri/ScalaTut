import Traits.CowboyArtist

object Traits {

  //can have implementation
  trait Similarity {
    def isSimilar(x: Any): Boolean
    def isNotSimilar(x: Any): Boolean = !isSimilar(x)
  }

  trait Drawable {
    def draw() { println("Init draw") }
  }

  trait Cowboy extends Drawable {
    override def draw() { println("Bang!") }
  }

  trait Artist extends Drawable {
    override def draw() { println("A pretty painting") }
  }

  // mixin class composition - can inherit multiple traits and solves diamond inheritance problem
  class CowboyArtist extends Cowboy with Artist

}

object TraitsMain extends App {
  (new CowboyArtist()).draw()
}

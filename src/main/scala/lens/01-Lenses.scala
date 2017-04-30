package lens

import monocle.macros.{GenLens, Lenses}
import monocle.function.all._
import com.softwaremill.quicklens._



case class Flight(id: Int)
case class Itinerary(id:String, flights: List[Flight])
case class Reservation(id: String, passenger: Map[String, Itinerary])




object MonocleOpticsMain extends App {

  val reservation = Reservation("reservation1",
    Map(
      "passenger1" -> Itinerary("itinerary1",List(Flight(1))),
      "passenger2" -> Itinerary("itinerary2",List(Flight(2)))
    )
  )

  case class Point(x: Int, y: Int)
  case class Point1(x: Int, y: Point)

  val p = Point1(5, Point(5, 6))
  println(GenLens[Point1](_.y.y).get(p))
  println(GenLens[Point1](_.y.y).set(333)(p))

  val passengerLens = GenLens[Reservation](_.passenger)
  val flightLens = GenLens[Itinerary](_.flights)
  println((passengerLens composeTraversal each composeLens flightLens composeTraversal each).getAll(reservation))

}

object QuickLensMain extends App {

  val reservation = Reservation("reservation1",
    Map(
      "passenger1" -> Itinerary("itinerary1",List(Flight(1))),
      "passenger2" -> Itinerary("itinerary2",List(Flight(2)))
    )
  )
  println(reservation.modify(_.passenger.at("passenger2").flights.eachWhere(_.id == 4).id).setTo(4))
}

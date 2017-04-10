package observatory

import java.time.LocalDate
import com.sksamuel.scrimage.RGBColor
import scala.math._

case class Location(lat: Double, lon: Double) {
  lazy val point:Point = Point(toRadians(lat), toRadians(lon))

}

case class Tile(x: Double, y: Double, zoom: Int) {
  lazy val location: Location = Location(
    lat = toDegrees(atan(sinh(Pi * (1.0 - 2.0 * y / (1 << zoom))))),
    lon = x / (1 << zoom) * 360.0 - 180.0)


  def toURI = new java.net.URI("http://tile.openstreetmap.org/" + zoom + "/" + x + "/" + y + ".png")
}

case class Point(x: Double, y: Double) {
  lazy val location:Location = Location(toDegrees(x), toDegrees(y))

  def haversineEarthDistance(other: Point): Double = {
    var r = 6372.8 // mean radius Earth in KM
    r * greatCircleDistance(other) * 1000
  }

  def greatCircleDistance(other: Point): Double = {
    val deltaX = abs(other.x - x)
    val deltaY = abs(other.y - y)

    val a =  pow(sin(deltaX / 2), 2) + cos(x) * cos(other.x) * pow(sin(deltaY / 2), 2)
    2 * atan2(sqrt(a), sqrt(1 - a))
  }

}


case class Color(red: Int, green: Int, blue: Int) {
  def pixel(alpha: Int = 255) = RGBColor(red, green, blue, alpha).toPixel
}

case class Joined(id: String, latitude:Double, longitude: Double, day: Int, month: Int, year: Int, temperature: Double)

case class StationDate(day: Int, month: Int, year: Int){
  def toLocalDate = LocalDate.of(year, month, day)
}

case class JoinedFormat(date: StationDate, location: Location, temperature: Double)


case class Station(id: String, latitude: Double, longitude: Double)

case class TemperatureRecord(id: String, day: Int, month: Int, year: Int, temperature: Double)
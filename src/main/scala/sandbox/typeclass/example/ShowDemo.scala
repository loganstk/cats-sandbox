package sandbox.typeclass.example

object ShowDemo extends App {

  import cats.implicits._

  println(Cat("Daisy", 2, "white").show)
}

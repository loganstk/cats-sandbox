package sandbox.exercise.printable

object PrintableDemo extends App {
  val daisy = Cat("Daisy", 2, "white")

  Printable.print(daisy)

  import PrintableSyntax._

  daisy.print
}

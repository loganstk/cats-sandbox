package sandbox.exercise.typeclass

trait Printable[A] {
  def format(value: A): String
}

object PrintableInstances {
  implicit val stringPrintable: Printable[String] = (a: String) => a
  implicit val intPrintable: Printable[Int] = (a: Int) => a.toString
}

object Printable {
  def format[A](value: A)(implicit p: Printable[A]): String =
    p.format(value)

  def print[A](value: A)(implicit p: Printable[A]): Unit =
    println(format(value))
}

object PrintableSyntax {
  implicit class PrintableOps[A](value: A) {
    def format(implicit p: Printable[A]): String =
      p.format(value)

    def print(implicit p: Printable[A]): Unit =
      println(format)
  }
}
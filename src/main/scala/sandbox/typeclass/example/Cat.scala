package sandbox.typeclass.example

import cats.implicits._
import cats.{Eq, Show}
import sandbox.typeclass.Printable

final case class Cat(name: String, age: Int, color: String)

object Cat {
  implicit val catPrintable: Printable[Cat] = new Printable[Cat] {
    def format(c: Cat): String =
      s"${c.name} is a ${c.age} year-old ${c.color} cat."
  }

  implicit val catShow: Show[Cat] =
    Show.show[Cat](c => s"${c.name.show} is a ${c.age.show} year-old ${c.color.show} cat.")

  implicit val catEq: Eq[Cat] = Eq.instance[Cat] {
    (cat1, cat2) =>
      cat1.name === cat2.name &&
        cat1.age === cat2.age &&
        cat1.color === cat2.color
  }
}

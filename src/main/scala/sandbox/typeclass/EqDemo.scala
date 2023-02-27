package sandbox.typeclass

import cats.implicits.catsSyntaxEq

object EqDemo extends App {
  val cat1 = Cat("Garfield", 38, "orange and black")
  val cat2 = Cat("Heathcliff", 33, "orange and black")

  println(cat1 === cat1)
  println(cat1 =!= cat2)

  val optionCat1 = Option(cat1)
  val optionCat2 = Option.empty[Cat]

  println(optionCat1 === optionCat1)
  println(optionCat1 =!= optionCat2)
}

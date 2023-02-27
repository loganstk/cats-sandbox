package sandbox.monoid.example

import cats.Monoid

object SuperAdder {
  def add[T](items: List[T])(implicit m: Monoid[T]): T =
    items.foldLeft(m.empty)(m.combine)
}

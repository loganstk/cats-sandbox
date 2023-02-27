package sandbox.monoid.example

import cats.Monoid

case class Order(totalCost: Double, quantity: Double)

object Order {
  implicit val orderMonoid: Monoid[Order] = new Monoid[Order] {
    override def empty: Order = Order(0, 0)

    override def combine(x: Order, y: Order): Order =
      Order(x.totalCost + y.totalCost, x.quantity + y.quantity)
  }
}
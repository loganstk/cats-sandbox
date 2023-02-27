package sandbox.semigroup

import cats.kernel.Semigroup

object SetSemigroups {
  implicit def intersection[A]: Semigroup[Set[A]] = new Semigroup[Set[A]] {
    def combine(x: Set[A], y: Set[A]): Set[A] = x intersect y
  }
}

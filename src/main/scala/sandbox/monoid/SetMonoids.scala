package sandbox.monoid

object SetMonoids {
  implicit def unionMonoid[A]: Monoid[Set[A]] = new Monoid[Set[A]] {
    def empty: Set[A] = Set.empty

    def combine(x: Set[A], y: Set[A]): Set[A] = x union y
  }

  implicit def symmetricDiff[A]: Monoid[Set[A]] = new Monoid[Set[A]] {
    def empty: Set[A] = Set.empty

    def combine(x: Set[A], y: Set[A]): Set[A] = (x diff y) union (y diff x)
  }
}

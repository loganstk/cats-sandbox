package sandbox.monoid

import org.scalacheck.Prop.forAll
import org.scalacheck.{Arbitrary, Properties}

trait MonoidSpec {
  def monoidProperties[A](m: Monoid[A], name: String)(implicit gen: Arbitrary[A]) =
    new Properties(name) {
      property("has identity") = forAll { (a: A) =>
        (m.combine(a, m.empty) == a) &&
          (m.combine(m.empty, a) == a)
      }

      property("is associative") = forAll { (a: A, b: A, c: A) =>
        m.combine(a, m.combine(b, c)) == m.combine(m.combine(a, b), c)
      }
    }
}

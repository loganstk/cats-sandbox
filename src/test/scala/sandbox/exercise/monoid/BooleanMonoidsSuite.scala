package sandbox.exercise.monoid

import org.scalacheck.Properties

object BooleanMonoidsSuite extends Properties("BooleanMonoids") with MonoidSpec {
  include(monoidProperties(BooleanMonoids.andMonoid, "And"))
  include(monoidProperties(BooleanMonoids.orMonoid, "Or"))
  include(monoidProperties(BooleanMonoids.xorMonoid, "Xor"))
}


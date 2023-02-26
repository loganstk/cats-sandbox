package sandbox.exercise.semigroup

trait Semigroup[A] {
  def combine(x: A, y: A): A
}

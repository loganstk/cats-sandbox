import cats.Id

// Identity monad
def pure[A](value: A): Id[A] = value
def map[A, B](initial: Id[A])(func: A => B): Id[B] = func(initial)
def flatMap[A, B](initial: Id[A])(func: A => Id[B]): Id[B] = func(initial)

val i = pure(123)
map(i)(_ * 2)
flatMap(123)(_ * 2)
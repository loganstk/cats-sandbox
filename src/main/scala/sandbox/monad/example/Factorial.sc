import scala.concurrent._
import scala.concurrent.ExecutionContext.Implicits._
import scala.concurrent.duration._
import cats.data.Writer
import cats.syntax.writer._
import cats.instances.vector._
import cats.syntax.applicative._


// Writer monad
type Logged[A] = Writer[Vector[String], A]

def slowly[A](body: => A) =
  try body finally Thread.sleep(100)

def factorial(n: Int): Logged[Int] =
  for {
    ans <- if (n == 0) {
      1.pure[Logged]
    } else {
      slowly(factorial(n - 1).map(_ * n))
    }
    _ <- Vector(s"fact $n $ans").tell
  } yield ans

Await.result(Future.sequence(Vector(
  Future(factorial(5)),
  Future(factorial(5))
).map(_.map(_.written))), 5.seconds)


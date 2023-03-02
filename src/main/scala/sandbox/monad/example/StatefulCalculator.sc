import cats.data.State
import cats.implicits.catsSyntaxApplicativeId

type CalcState[A] = State[List[Int], A]

def operator(op: (Int, Int) => Int): CalcState[Int] =
  State[List[Int], Int] {
    case b :: a :: tail =>
      val res = op(a, b)
      (res :: tail, res)
    case _ => sys.error("Fail!")
  }

def operand(x: Int): CalcState[Int] = State[List[Int], Int] { stack =>
  (x :: stack, x)
}

def evalOne(sym: String): CalcState[Int] =
  sym match {
    case "+" => operator(_ + _)
    case "-" => operator(_ - _)
    case "*" => operator(_ * _)
    case "/" => operator(_ / _)
    case _ => operand(sym.toInt)
  }

evalOne("42").runA(Nil).value

val program = for {
  _ <- evalOne("1")
  _ <- evalOne("2")
  ans <- evalOne("+")
} yield ans

program.runA(Nil).value

def evalAll(input: List[String]): CalcState[Int] =
  input.foldLeft(0.pure[CalcState]) { (a, b) => a.flatMap(_ => evalOne(b)) }

val multiStageProgram = evalAll(List("1", "2", "+", "3", "*"))
multiStageProgram.runA(Nil).value

def evalInput(input: String): Int =
  evalAll(input.split(" ").toList).runA(Nil).value

evalInput("1 2 + 3 4 + *")
import cats.data.State

val a = State[Int, String] { state =>
  (state, s"The state is $state")
}

// Get the state and the result
val (state, result) = a.run(10).value

// Get the state, ignore the result
val justTheState = a.runS(10).value

// Get the result, ignore the state
val justTheResult = a.runA(10).value

val step1 = State[Int, String]{ num =>
  val ans = num + 1
  (ans, s"Result of step1: $ans")
}

val step2 = State[Int, String]{ num =>
  val ans = num * 2
  (ans, s"Result of step2: $ans")
}

val both = for {
  a <- step1
  b <- step2
} yield (a, b)

val (state, result) = both.run(20).value
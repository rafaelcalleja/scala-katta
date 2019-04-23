package essential.Calculator

import org.scalatest.{FlatSpec, Matchers}

class CalculatorTest extends FlatSpec with Matchers {
  "Eval" should "returns Success Double" in {
    Number(2.0).eval should be (Success(2.0))
    Addition(Number(2.0), Number(2.0)).eval should be (Success(4.0))
    Subtraction(Number(2.0), Number(2.0)).eval should be (Success(0.0))

    Addition(Addition(Number(2.0), Number(2.0)), Number(2.0)).eval should be (Success(6.0))

    Division(Number(4), Number(0)).eval should be (Failure("Division by zero"))

    Addition(SquareRoot(Number(-1.0)), Number(2.0)).eval should be (Failure("Square root of negative number"))

    Addition(SquareRoot(Number(4.0)), Number(2.0)).eval should be (Success(4.0))

    Division(Number(2.0), Number(2.0)).eval should be (Success(1.0))
    Division(Number(4.0), Number(2.0)).eval should be (Success(2.0))


    SquareRoot(Subtraction(Number(2.0), Number(3.0))).eval should be (Failure("Square root of negative number"))

    SquareRoot(SquareRoot(SquareRoot(Number(16.0)))).eval should be (SquareRoot(Number(2)).eval)
  }


}
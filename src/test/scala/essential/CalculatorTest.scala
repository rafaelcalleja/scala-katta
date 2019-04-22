package essential

import org.scalatest.{FlatSpec, Matchers}

class CalculatorTest extends FlatSpec with Matchers {
  "Calculations" should "returns the Result" in {

    Addition(SquareRoot(Number(-1.0)), Number(2.0)).eval should be (Failure("Square root of negative number")))

    Addition(SquareRoot(Number(4.0)), Number(2.0)).eval should be (Success(4.0))

    Division(Number(4), Number(0)).eval should be (Failure("Division by zero"))
  }


}
package essential

/**
  * Our representation is:
  * An Expression is an Addition , Subtraction , or a Number ;
  * An Addition has a left and right Expression;
  * A Subtraction has a left and right Expression; or
  * A Number has a value of type Double .
  */
sealed trait Expression {
  def /(expression: Expression): Result = expression match {
    case Number(_ == 0.0) => Failure("Square root of negative number")
    case Number(_) => Success(this.eval / _)
    case _ => _
  }

  def eval: Result = this match {
    case Addition(left, right) => left.eval + right.eval
    case Subtraction(left, right) =>
    case Number(value) => Success(value)
    case Division(left, right) => right.eval match {
      case Success(0.0) => Failure("Division by zero") case _ => left / right
    }
    case SquareRoot(number) => number.eval match { case Success(_ < 0) => Failure("Square root of negative number") case _ => _ }
  }
}

case class Addition(left: Expression, right: Expression) extends Expression
case class Subtraction(left: Expression, right: Expression) extends Expression
case class Number(value: Double) extends Expression //base case


case class Division(left: Expression, right: Expression) extends Expression
case class SquareRoot(number: Expression) extends Expression

sealed trait Result {}
case class Success(value: Double) extends Result
case class Failure(reasonWhy: String) extends Result

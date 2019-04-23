package essential

import scala.math._

/**
  * Our representation is:
  * An Expression is an Addition , Subtraction , or a Number ;
  * An Addition has a left and right Expression;
  * A Subtraction has a left and right Expression; or
  * A Number has a value of type Double .
  */
sealed trait Expression {
  def operation(left: Expression, right: Expression, f: (Double, Double) => Result): Result = (left.eval, right.eval) match {
      case (Success(a), Success(b)) => f(a, b)
      case (Failure(a), _) => Failure(a)
      case (_, Failure(a)) => Failure(a)
  }

  def eval: Result = this match {
    case Number(n) => Success(n)
    case Addition(left, right) => operation(left, right, (a, b) => Success(a + b))
    case Subtraction(left, right) => operation(left, right, (a, b) => Success(a - b))

    case Division(left, right) => (left, right) match {
      case (l, r) => operation(l, r, (a, b) =>
        if (b == 0.0)
          Failure("Division by zero")
        else Success(a / b)
      )
    }

    case SquareRoot(number) => number.eval match {
      case Success(a) if a < 0 => Failure("Square root of negative number")
      case Success(a) => Success(sqrt(a))
    }
  }
}

final case class Addition(left: Expression, right: Expression) extends Expression
final case class Subtraction(left: Expression, right: Expression) extends Expression
final case class Number(value: Double) extends Expression //base case


final case class Division(left: Expression, right: Expression) extends Expression
final case class SquareRoot(number: Expression) extends Expression

sealed trait Result {
  def result: String = this match {
    case Success(value) => value.toString
    case Failure(reasonWhy) => reasonWhy
  }
}
case class Success(value: Double) extends Result
case class Failure(reasonWhy: String) extends Result

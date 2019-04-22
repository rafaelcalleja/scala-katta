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
  def eval: Result = this match {
    case Number(n) => Success(n)
    case Addition(left, right) => (left.eval, right.eval) match {
      case (Success(a), Success(b)) => Success(a.toDouble + b.toDouble)
      case (_, Failure(a)) => Failure(a.toString)
      case (Failure(a), _) => Failure(a.toString)
    }
    case Subtraction(left, right) => (left.eval, right.eval) match {
      case (Success(a), Success(b)) => Success(a - b)
      case (_, Failure(a)) => Failure(a.toString)
      case (Failure(a), _) => Failure(a.toString)
    }

    case Division(left, right) => (left.eval, right.eval) match {
      case (_, Success(0.0)) => Failure("Division by zero")
      case (Success(a), Success(b)) => Success(a.toDouble / b.toDouble)
    }

    case SquareRoot(number) => number.eval.result.toDouble match {
      case a if a < 0 => Failure("Square root of negative number")
      case a => Success(sqrt(a))
    }
  }
}

case class Addition(left: Expression, right: Expression) extends Expression
case class Subtraction(left: Expression, right: Expression) extends Expression
case class Number(value: Double) extends Expression //base case


case class Division(left: Expression, right: Expression) extends Expression
case class SquareRoot(number: Expression) extends Expression

sealed trait Result {
  def result: String = this match {
    case Success(value) => value.toString
    case Failure(reasonWhy) => reasonWhy
  }
}
case class Success(value: Double) extends Result
case class Failure(reasonWhy: String) extends Result

package essential.Sequence

import scala.language.implicitConversions

/**
  * Fold Pattern
  *
  * For an algebraic datatype A, fold converts it to a generic type B . Fold is a structural recursion with:
  * • one func on parameter for each case in A ;
  * • each func on takes as parameters the fields for its associated class;
  * • if A is recursive, any func on parameters that refer to a recursive field take a parameter of type B .
  *
  * The right-hand side of pattern matching cases, or the polymorphic methods as appropriate, consists of calls to the appropriate func on.
  */
sealed trait IntList[B] {
  def length: Int = fold[Int](0, (_, tail) => 1 + tail )

  def double: IntList[B] = fold[IntList[B]](End(), (that, tail) => Pair[B](that * 2, tail) )

  def product: Int = fold[Int](1, (that, next) => that * next)

  def sum: Int = fold[Int](0, (that, next) => that + next)

  implicit def BToInt(value: B): Int = value.toString.toInt
  implicit def IntToB(value: Int): B = value.asInstanceOf[B]

  def fold[A](end: A, f: (B, A) => A): A =
    this match {
      case End() => end
      case Pair(hd, tl) => f(hd, tl.fold(end, f))
    }
}

case class End[B]() extends IntList[B]
case class Pair[B](head: B, tail: IntList[B]) extends IntList[B]